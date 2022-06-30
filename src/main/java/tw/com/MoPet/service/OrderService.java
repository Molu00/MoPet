package tw.com.MoPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.Order;
import tw.com.MoPet.model.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository OrderDAO;
	
	public Order insertOrder(Order order) {
		return OrderDAO.save(order);
	}
}
