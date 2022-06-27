package tw.com.MoPet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.CartItems;
import tw.com.MoPet.model.cartitemsRepository;

@Service
@Transactional
public class CartitemsService {
	@Autowired
	private cartitemsRepository cartitemsDao;
	
//	@Autowired
//	private CartitemsService ciService;
//	
//	@Autowired
//	private ProductService pService;

	public void insertCartItems(CartItems items) {
		cartitemsDao.save(items);
	}
	
	public void deleteItemByTwoKeys(Integer productid,Integer cartid) {
		cartitemsDao.deleteItemByTwoKeys(productid, cartid);
	}
	
//	public CartItems getById(Integer id) {
//		Optional<CartItems> option=cartitemsDao.findById(id);
//		if(option.isPresent()) {
//		return option.get();
//			}
//		return null;
//	}
	public CartItems findItemByTwoKeys(Integer productid, Integer cartid){
		return cartitemsDao.findItemByProductId(productid, cartid);
	}
	
	public List<CartItems> findItemByCart(Integer cartid){
		return cartitemsDao.findItemByCart(cartid);
	}
	
//	public void insertCartItems2(Cart cart) {
//		Map<Integer, Integer> itemsMap = new LinkedHashMap<>();
//		List<CartItems> list = ciService.getItems(cart.getCartId());
//		
//		for (CartItems x : list) {
//			Integer key = x.getpId().getpId().intValue();
//			Integer value = x.getCartItemsAmount();
//
//			if (itemsMap.get(key) != null) {
//				itemsMap.put(key, itemsMap.get(key) + value);
//			} else {
//				itemsMap.put(key, value);
//			}
//		}
//		for(Integer thekey:itemsMap.keySet()) {
//			CartItems item=cartitemsDao.findItemByProductId(thekey, cart.getCartId());
//			if(item!=null) {
//				cartitemsDao.save(item);
//			}
//			else {
//				CartItems items = new CartItems();
//				items.setpId(pService.getById(thekey));
//				items.setCartItemsAmount(itemsMap.get(thekey));
//				items.setCartId(cart);
//				cartitemsDao.save(item);
//			}
//		}
//	}
	
	public List<CartItems> findItemsList(){
		return cartitemsDao.findAll();
	}
	
//	public List<CartItems> findGourpById(Integer id){
//		return cartitemsDao.findGourpById(id);
//	}
	
	public List<CartItems> getItems(Integer cartid){
		return cartitemsDao.findItemsList(cartid);
	}
	
	
//	public List<CartItems> getItems(Integer cartid){
//		return cartitemsDao.findAllByCartId(cartid);
//	}
}
