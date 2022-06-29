package tw.com.MoPet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.com.MoPet.model.Cart;
import tw.com.MoPet.model.CartItems;
import tw.com.MoPet.model.Payment;
import tw.com.MoPet.model.Shipping;
import tw.com.MoPet.model.member;
import tw.com.MoPet.service.CartService;
import tw.com.MoPet.service.CartitemsService;
import tw.com.MoPet.service.PaymentService;
import tw.com.MoPet.service.ProductService;
import tw.com.MoPet.service.ShippingService;
import tw.com.MoPet.service.memberService;

@Controller
public class OrderController {

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
				Integer tempSum=0;
				
				for(CartItems items:productList) {
					Integer aoumnt=items.getCartItemsAmount().intValue();
					Integer price=items.getpId().getpPrice();
					tempSum+=aoumnt*price;
				}
				
				List<Shipping> shipList=shipService.findAll();
				List<Payment> payList=payService.findAll();
				member member=mService.findById(memId);
				
				System.out.println("訂購人名稱？ "+member.getMemberName());
				System.out.println("訂購人電話？ "+member.getMemberTel());
				System.out.println("訂購人地址？ "+member.getMemberAddress());
				
				mvc.getModel().put("member", member);
				mvc.getModel().put("tempSum", tempSum);
				mvc.getModel().put("shipList", shipList);
				mvc.getModel().put("payList", payList);
				mvc.getModel().put("productList", productList);
				mvc.setViewName("checkOrder");
			}
		}
		return mvc;
	}
}
