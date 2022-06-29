package tw.com.MoPet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.Payment;
import tw.com.MoPet.model.PaymentRepository;

@Service
@Transactional
public class PaymentService {
	
	@Autowired
	private PaymentRepository PaymentDao;
	
	public List<Payment> findAll(){
		return PaymentDao.findAll();
	}

}
