package tw.com.MoPet.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.OrderRepository;

@Service
@Transactional
public class OrderService {
	private OrderRepository OrderDAO;
	
	

}
