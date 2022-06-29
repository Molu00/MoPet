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
	
	public void insertCartItems(CartItems items) {
		cartitemsDao.save(items);
	}
	
	public void deleteItem(Integer id) {
		cartitemsDao.deleteById(id);
	}
	
	public CartItems findItemByTwoKeys(Integer productid, Integer cartid){
		return cartitemsDao.findItemByTwoKeys(productid, cartid);
	}
	
	public List<CartItems> findItemByCart(Integer cartid){
		return cartitemsDao.findItemByCart(cartid);
	}
	
	public List<CartItems> findItemsList(){
		return cartitemsDao.findAll();
	}

}
