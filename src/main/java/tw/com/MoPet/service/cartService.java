package tw.com.MoPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.cart;
import tw.com.MoPet.model.cartRepository;

@Service
@Transactional
public class cartService {

	@Autowired
	private cartRepository cartDao;

	public void insertCart(cart cart) {
		cartDao.save(cart);
	}
	
	public cart findByMemberId(Integer id) {
		System.out.println("測試"+cartDao.findByfkMemberId(id));
		return cartDao.findByfkMemberId(id);
	}
}
