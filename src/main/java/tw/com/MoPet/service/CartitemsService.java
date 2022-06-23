package tw.com.MoPet.service;

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
	
}
