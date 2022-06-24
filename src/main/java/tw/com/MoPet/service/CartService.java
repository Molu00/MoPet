package tw.com.MoPet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.Cart;
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
	
//	public Integer findByMemberId(Integer id) {
//	return cartDao.findCartIdByfkMemberId(id);
//}
	
//	public Cart findByMemberId(member id) {
//		return cartDao.findByFkMemberId(id);
//	}
	
	
	public Optional<Cart> findByMemberId(Integer id) {
		return cartDao.testMember(id);
	}
}
