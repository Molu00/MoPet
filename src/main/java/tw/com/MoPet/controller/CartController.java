package tw.com.MoPet.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tw.com.MoPet.model.Cart;
import tw.com.MoPet.model.CartItems;
import tw.com.MoPet.model.Product;
import tw.com.MoPet.model.member;
import tw.com.MoPet.service.CartService;
import tw.com.MoPet.service.CartitemsService;
import tw.com.MoPet.service.ProductService;
import tw.com.MoPet.service.memberService;

@Controller
public class CartController {
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private CartitemsService ciService;
	
	@Autowired
	private CartService cService;
	
	@Autowired
	private memberService mService;

	
	@GetMapping("add/cartItems/{id}")
	public String addCartList(@PathVariable Integer id,HttpSession session) {
		System.out.println("有走進來嗎？？？");
		
//		Integer getCartId=cService.findByMemberId(100);
//		System.out.println("=======================CartId :"+getCartId);
		
		try {
			Optional<Cart> cart=cService.findByMemberId(155);
//			System.out.println("=======================CartId :"+cart);
			//先用memberId撈購物車出來
			
			Cart cart2 = null;
			//如果照著欄位沒有撈到cart，新建cart
			if(cart.isEmpty()){
				
			Cart newCart=new Cart();
			
			System.out.println("======================我想想這邊究竟該怎麼辦");
			member tempMember=mService.findById(151);
			System.out.println(tempMember );
			if(tempMember!=null) {
			newCart.setFkMemberId(tempMember);
			cart2 = cService.insertCart(newCart);
			
			System.out.println(cart2.getCartId());
			
			//上述已建立購物車
			//如果照著欄位撈有購物車，但未成為訂單
			}
			System.out.println("cart2 status"+cart2.isCartStatus() );
			//抓判定status，成為訂單沒，如果還沒
			if(cart2.isCartStatus()==false) {
				//new一個items
				CartItems items=new CartItems();
				//抓商品
				Product getProduct=pService.getById(id);
				
				if(getProduct!=null) {
					System.out.println("getProduct"+getProduct );
					System.out.println("======================我想想這邊究竟該怎麼辦2");
				items.setpId(getProduct);
				items.setCartId(cart2);
				//預設都先1
				items.setCartItemsAmount(1);
				ciService.insertCartItems(items);
			}}}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("這裡會是什麼樣的問題跳出來=================================="+ e.getMessage());
		}finally {
			
		}
		
		return "redirect:/shop/products";
	}
	
}
