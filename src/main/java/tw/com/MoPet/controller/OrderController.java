package tw.com.MoPet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.com.MoPet.service.CartService;
import tw.com.MoPet.service.CartitemsService;
import tw.com.MoPet.service.ProductService;
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
	
	@GetMapping("checkIntoOrder")
	public void CheckOrder(HttpSession session) {
		Integer memId = Integer.parseInt(session.getAttribute("cart_ID").toString());
		//用id抓購物車，先判定status是否已結帳
		//抓出status為否的明細
		//
		
		
		
	}

}
