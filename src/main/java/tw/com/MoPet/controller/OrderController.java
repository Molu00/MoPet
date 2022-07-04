package tw.com.MoPet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutDevide;
import ecpay.payment.integration.domain.AioCheckOutOneTime;
import tw.com.MoPet.model.Cart;
import tw.com.MoPet.model.CartItems;
import tw.com.MoPet.model.Order;
import tw.com.MoPet.model.OrderDetail;
import tw.com.MoPet.model.Payment;
import tw.com.MoPet.model.Shipping;
import tw.com.MoPet.model.member;
import tw.com.MoPet.service.CartService;
import tw.com.MoPet.service.CartitemsService;
import tw.com.MoPet.service.OrderDetailService;
import tw.com.MoPet.service.OrderService;
import tw.com.MoPet.service.PaymentService;
import tw.com.MoPet.service.ProductService;
import tw.com.MoPet.service.ShippingService;
import tw.com.MoPet.service.memberService;

@Controller
public class OrderController {

	@Autowired
	private OrderService oService;

	@Autowired
	private ProductService pService;

	@Autowired
	private CartitemsService ciService;

	@Autowired
	private CartService cService;

	@Autowired
	private memberService mService;

	@Autowired
	private ShippingService shipService;

	@Autowired
	private PaymentService payService;
	
	@Autowired
	private OrderDetailService odService;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@GetMapping("checkIntoOrder")
	public ModelAndView CheckOrder(ModelAndView mvc, HttpSession session) {
		// 先判有沒有id，沒有的話先跳去登入
		// 沒有ID會一直卡在登入頁面，需要註冊才能進入頁面
		if (session.getAttribute("loginOK") == null) {
			String prePage = "redirect:/checkIntoOrder";
			session.setAttribute("PrePage", prePage);
			mvc.setViewName("redirect:/login");

		} else {

			// 用id抓購物車與status判定是否有車要結帳 (下判斷，沒有的話要滾去買東西才對)(非null, 往下走)
			// 有的話，用cart的id去cartItems，塞進model裡
			// 或者抓數值出來直接跟productprice與數量相乘
			// 撈shipping
			// 撈payment
			// 撈member
			// 回傳至checkOrderjsp裡

			Integer memId = Integer.parseInt(session.getAttribute("cart_ID").toString());
			Cart cart = cService.findBymIdAndcStatus(memId, false);

			if (cart != null) {
				List<CartItems> productList = ciService.findItemByCart(cart.getCartId());
				Integer tempSum = 0;

				for (CartItems items : productList) {
					Integer aoumnt = items.getCartItemsAmount().intValue();
					Integer price = items.getpId().getpPrice();
					tempSum += aoumnt * price;
				}

				List<Shipping> shipList = shipService.findAll();
				List<Payment> payList = payService.findAll();
				member member = mService.findById(memId);

				mvc.getModel().put("member", member);
				mvc.getModel().put("tempSum", tempSum);
				mvc.getModel().put("shipList", shipList);
				mvc.getModel().put("payList", payList);
				mvc.getModel().put("productList", productList);
				mvc.setViewName("checkOrder");
			} else {
				mvc.setViewName("cartItemsEmpty");
			}
		}
		return mvc;
	}

	@PostMapping("intoOrder")
	public String intoOrder(@ModelAttribute Order order,Model model, ModelAndView mvc, HttpSession session, HttpServletRequest requeset, HttpServletResponse response) throws IOException {

		if (session.getAttribute("loginOK") == null) {
			String prePage = "redirect:/intoOrder";
			session.setAttribute("PrePage", prePage);
			mvc.setViewName("redirect:/login");

		} else {

			Date now = pService.getTimeNow();
			order.setOrderAdded(now);

			System.out.println(order.toString());

			Order getOrder=oService.insertOrder(order);
			
			String orderStr="";
			
			// session撈memberid出來
			// 用id跟status撈未結帳那台，改成結帳

			Integer memId = Integer.parseInt(session.getAttribute("cart_ID").toString());
			Cart cart = cService.findBymIdAndcStatus(memId, false);
			
			//將未成立的單子從items裡抓出List
			List<CartItems> itemsList = ciService.findItemByCart(cart.getCartId());
			for (CartItems content : itemsList) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderId(getOrder);
				orderDetail.setpId(content.getpId());
				orderDetail.setProductAmount(content.getCartItemsAmount());
				odService.insertOdDetail(orderDetail);
				orderStr+=content.getpId().getpName()+" "+content.getpId().getpPrice()+"元 "+content.getCartItemsAmount()+" 個#";
			}
			
			cart.setCartStatus(true);
			cService.insertCart(cart);
			// 確認訂單是否成立, 刪cartItems跟cart
			// 確認一下如果重新走買東西的流程是不是會報錯

			Cart trueCart = cService.findBymIdAndcStatus(memId, true);
			ciService.deleteListByCartId(trueCart.getCartId());
			cService.deleteCart(trueCart);
			
			//接綠界結帳
			//嘗試一下
			if(getOrder.getPaymentId().getPayId()==2) {
				AllInOne aio=new AllInOne("");
				AioCheckOutOneTime aoiCheck=new AioCheckOutOneTime();
				
				aoiCheck.setMerchantID("2000214");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				sdf.setLenient(false);
				aoiCheck.setMerchantTradeDate(sdf.format(new Date()));
				
				aoiCheck.setTotalAmount(getOrder.getOrderTotal().toString());
				
				aoiCheck.setTradeDesc("testOrder1");
				
				aoiCheck.setItemName(orderStr);
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
				String nowStr = sdf1.format(new Date()).toString();
				aoiCheck.setMerchantTradeNo(nowStr+getOrder.getOrderId());
				
				aoiCheck.setReturnURL("http://localhost:8080/MoPet/order/returnURL");
				
				aoiCheck.setOrderResultURL("http://localhost:8080/MoPet/showHistoryOrder");
	
				aoiCheck.setClientBackURL("http://localhost:8080/MoPet/shop/products");
				
				aoiCheck.setNeedExtraPaidInfo("N");
				
				aoiCheck.setRedeem("Y");
				
				System.out.println(aoiCheck.toString());
				
				String form=aio.aioCheckOut(aoiCheck, null);
	//			return form;
				model.addAttribute("ecpay",form);}
			
			
//			//暫時將訂單成功付款的資訊藏這裡
//			getOrder.setPaymentStatus(true);
//			oService.insertOrder(getOrder);
			
			System.out.println("this order ========= "+getOrder.getOrderId());
//			PrintWriter out = response.getWriter();
//			response.setContentType("text/html;charset=UTF-8");
//			out.print(aio.aioCheckOut(aoiCheck, null));
		}
//	return "orderOK";
		return "checkOutECPay";
	}
	
	@PostMapping("order/returnURL")
	public void returnURL(@RequestParam("MerchantTradeNo") String MerchantTradeNo, @RequestParam("RtnCode") int RtnCode,
			@RequestParam("TradeAmt") int TradeAmt, HttpServletRequest request, Model model) {
		if ((request.getRemoteAddr().equalsIgnoreCase("175.99.72.1")
				|| request.getRemoteAddr().equalsIgnoreCase("175.99.72.11")
				|| request.getRemoteAddr().equalsIgnoreCase("175.99.72.24")
				|| request.getRemoteAddr().equalsIgnoreCase("175.99.72.28")
				|| request.getRemoteAddr().equalsIgnoreCase("175.99.72.32")) && RtnCode == 1) {

			System.out.println("傳進來的 MerchantTradeNo "+MerchantTradeNo);
			System.out.println("傳進來的 TradeAmt "+TradeAmt);
//			String orderIdStr =MerchantTradeNo.substring(14);
//			System.out.println(MerchantTradeNo);
//			//抓訂單id，用id搜尋訂單然後改狀態
//			String orderIdStr = MerchantTradeNo.substring(8);
//			int OrderId = Integer.parseInt(orderIdStr);
//			Order order =oService.getOrderById(OrderId);
//			order.setPaymentStatus(true);
//			oService.insertOrder(order);
//			//findById(OrderId)
			logger.info("test check out ok");
		}
	}
	
//	@PostMapping("showHistoryOrder")
	@RequestMapping(path = "/showHistoryOrder", method = {RequestMethod.GET,RequestMethod.POST})
	public String showHistoryOrder(Model model, HttpSession session,@RequestParam("MerchantTradeNo") String MerchantTradeNo) {

		String orderIdStr =MerchantTradeNo.substring(14);
		Integer OrderId = Integer.parseInt(orderIdStr);
		Order order =oService.getOrderById(OrderId);
		order.setPaymentStatus(true);
		oService.insertOrder(order);
		//		member member = (member) session.getAttribute("loginOK");
//		Integer memberId=member.getId();
//		//回來寫一個OrderService的findBytwoKeys去找未付款單子
//		Order thisOrder=oService.findBymIdAndcStatus(memberId, false);
////		Member member = memberService.findById(sessionUId);
//		List<OrderDetail> orderDetailList=odService.findOrderDetailByCart(thisOrder.getOrderId());
//		
//		model.addAttribute("orderDetail"+orderDetailList);
//		
//		thisOrder.setPaymentStatus(true);
//		oService.insertOrder(thisOrder);
		
		//透過使用者取得訂單資料並呈現，此處先用index代替
		logger.info("test check out HistoryOrder");
		return "orderOK";
	}
	
}
