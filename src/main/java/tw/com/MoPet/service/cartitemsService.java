package tw.com.MoPet.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.cart;
import tw.com.MoPet.model.cartitems;
import tw.com.MoPet.model.cartitemsRepository;

@Service
@Transactional
public class cartitemsService {
	private cartitemsRepository cartitemsDao;

}
