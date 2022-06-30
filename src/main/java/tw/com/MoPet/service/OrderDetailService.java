package tw.com.MoPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.OrderDetail;
import tw.com.MoPet.model.OrderDetailRepository;

@Service
@Transactional
public class OrderDetailService {
	
	@Autowired
	private OrderDetailRepository odDAO;
	
	public void insertOdDetail(OrderDetail orderDetail) {
		odDAO.save(orderDetail);
	}
	

}
