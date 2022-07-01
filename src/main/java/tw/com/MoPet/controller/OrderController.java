package tw.com.MoPet.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public String intoOrder(@ModelAttribute Order order, ModelAndView mvc, HttpSession session) {

		if (session.getAttribute("loginOK") == null) {
			String prePage = "redirect:/intoOrder";
			session.setAttribute("PrePage", prePage);
			mvc.setViewName("redirect:/login");

		} else {

			Date now = pService.getTimeNow();
			order.setOrderAdded(now);

			System.out.println(order.toString());

			Order getOrder=oService.insertOrder(order);

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
			}
			
			cart.setCartStatus(true);
			cService.insertCart(cart);
			// 確認訂單是否成立, 刪cartItems跟cart
			// 確認一下如果重新走買東西的流程是不是會報錯

			Cart trueCart = cService.findBymIdAndcStatus(memId, true);
			ciService.deleteListByCartId(trueCart.getCartId());
			cService.deleteCart(trueCart);

		}
	return "orderOK";
	}
}
