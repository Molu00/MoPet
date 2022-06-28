package tw.com.MoPet.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping("minus/cartItem/{id}")
	public String minusItems(@PathVariable Integer id, HttpSession session) {
		int memId = Integer.parseInt(session.getAttribute("cart_ID").toString());
		Optional<Cart> cart = cService.findByMemberId(memId);
		Integer cartId = cart.get().getCartId().intValue();

		CartItems item = ciService.findItemByTwoKeys(id, cartId);
		item.setCartItemsAmount(item.getCartItemsAmount() - 1);

		if (item.getCartItemsAmount() != 0) {
			ciService.insertCartItems(item);
		} else {
			ciService.deleteItem(item.getCartItemsId());
		}
		return "redirect:/into/cart";
	}

	@GetMapping("add/cartItem/{id}")
	public String addItems(@PathVariable Integer id, HttpSession session) {
		int memId = Integer.parseInt(session.getAttribute("cart_ID").toString());
		Optional<Cart> cart = cService.findByMemberId(memId);

		Integer cartId = cart.get().getCartId().intValue();
		CartItems item = ciService.findItemByTwoKeys(id, cartId);
		item.setCartItemsAmount(item.getCartItemsAmount() + 1);
		ciService.insertCartItems(item);

		return "redirect:/into/cart";
	}

	@GetMapping("delete/cartItem/{id}")
	public String deleteItems(@PathVariable Integer id, HttpSession session) {
		int memId = Integer.parseInt(session.getAttribute("cart_ID").toString());
		Optional<Cart> cart = cService.findByMemberId(memId);
		Integer cartId = cart.get().getCartId().intValue();

		CartItems items = ciService.findItemByTwoKeys(id, cartId);

		ciService.deleteItem(items.getCartItemsId());

//		ciService.deleteItemByTwoKeys(id,cartId);
		return "redirect:/into/cart";
	}

	@GetMapping("add/cartItems/{id}")
	public String addCartList(@PathVariable Integer id, HttpSession session) {
		
		if (session.getAttribute("loginOK")== null) {
			   return "login";
			  }
		
		else {
			int memId = Integer.parseInt(session.getAttribute("cart_ID").toString());
		Optional<Cart> cart = cService.findByMemberId(memId);
		Cart tempCart = null;

		if (!cart.isEmpty() && cart.get().isCartStatus() == false) {
			CartItems item = ciService.findItemByTwoKeys(id, cart.get().getCartId());
			if (item != null) {
				item.setCartItemsAmount(item.getCartItemsAmount() + 1);
				ciService.insertCartItems(item);
			} else {
				// new一個items
				CartItems items = new CartItems();
				// 抓商品
				Product getProduct = pService.getById(id);

				if (getProduct != null) {
					System.out.println("究竟商品有沒有抓到");
					// 塞值囉！
					items.setpId(getProduct);
					items.setCartId(cart.get());
					// 數量都先1
					items.setCartItemsAmount(1);
					// insert資料進清單裡！
					ciService.insertCartItems(items);
				}
			}
		}

		// 如果照著欄位沒有撈到車車
		if (cart.isEmpty() || cart.get().isCartStatus() == true) {
			System.out.println("靠著memberid沒有抓到購到購物車，cart: " + cart.isEmpty());
			// 建立一個新車車，從memberService裡撈member資料出來
			Cart newCart = new Cart();
			member tempMember = mService.findById(memId);

			// 如果member有資料，新車車塞member的值
			if (tempMember != null) {
				newCart.setFkMemberId(tempMember);
				// 存進新車車裡，回傳到最初建立的null車車
				tempCart = cService.insertCart(newCart);

				// 有車車了
				// 車車的status如果是false，代表訂單還沒成立
				// new一個items
				CartItems items = new CartItems();
				Product getProduct = pService.getById(id);

				// 塞值囉！
				items.setpId(getProduct);
				items.setCartId(tempCart);
				// 數量都先1
				items.setCartItemsAmount(1);
				// insert資料進清單裡！
				ciService.insertCartItems(items);
			}
		}
		return "redirect:/shop/products";}
		
		
	}

	@GetMapping("into/cart")
	public ModelAndView seeCartItems(ModelAndView mvc, HttpSession session) {
		int memId = Integer.parseInt(session.getAttribute("cart_ID").toString());
		Optional<Cart> cart = cService.findByMemberId(memId);

		if (cart.isEmpty()) {
			mvc.setViewName("cartItemsEmpty");
		}

		else {
			List<CartItems> cartList = ciService.findItemByCart(cart.get().getCartId());
			if (cartList.isEmpty() || cart.get().isCartStatus() == true) {
				mvc.setViewName("cartItemsEmpty");
			}
			else if (!cart.isEmpty() && cart.get().isCartStatus() == false) {
				System.out.println("有從memberid抓到購物車車 cart Id: " + cart.get().getCartId());
				List<CartItems> productList = ciService.findItemByCart(cart.get().getCartId());
				mvc.getModel().put("productList", productList);
				mvc.setViewName("cartItems");
			}
		}

		return mvc;
	}
}
