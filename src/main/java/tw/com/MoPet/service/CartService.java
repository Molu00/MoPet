package tw.com.MoPet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.Cart;
import tw.com.MoPet.model.Product;
import tw.com.MoPet.model.cartRepository;
import tw.com.MoPet.model.member;

@Service
@Transactional
public class CartService {

	@Autowired
	private cartRepository cartDao;

	public Cart insertCart(Cart cart) {
		return cartDao.save(cart);
	}
	
	public Optional<Cart> findByMemberId(Integer id) {
		return cartDao.testMember(id);

	}
	
	public Cart findBymIdAndcStatus(Integer memberId,boolean status) {
		Optional<Cart> option= cartDao.findBymIdAndcStatus(memberId, status);
		if(option.isPresent()) {
			return option.get();
				}
			return null;
	}
	
	public void deleteCart(Cart cart) {
		cartDao.delete(cart);
	}
	
}
