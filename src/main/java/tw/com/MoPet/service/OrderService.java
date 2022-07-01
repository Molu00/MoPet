package tw.com.MoPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	
	public Page<Order> findByPage(Integer productPageNumber){
		PageRequest pgo=PageRequest.of(productPageNumber-1,10,Sort.Direction.DESC,"orderAdded");
		Page<Order> page=OrderDAO.findAll(pgo);
		return page;
	}
}
