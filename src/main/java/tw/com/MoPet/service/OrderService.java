package tw.com.MoPet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.Order;
import tw.com.MoPet.model.OrderDetail;
import tw.com.MoPet.model.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository OrderDAO;
	
	public Order getOrderById(Integer orderId) {
		Optional<Order> option=OrderDAO.findById(orderId);
		if(option.get()!=null) {
			return option.get();
		}
		return null;
	}
	
	public Order insertOrder(Order order) {
		return OrderDAO.save(order);
	}
	
	public Page<Order> findByPage(Integer productPageNumber){
		PageRequest pgo=PageRequest.of(productPageNumber-1,10,Sort.Direction.DESC,"orderAdded");
		Page<Order> page=OrderDAO.findAll(pgo);
		return page;
	}
	
	public Order findBymIdAndcStatus(Integer memberId,boolean paymentStatus) {
		Optional<Order> option= OrderDAO.findBymIdAndcStatus(memberId, paymentStatus);
		if(option.get()!=null) {
			return option.get();
		}
		return null;
	}
}
