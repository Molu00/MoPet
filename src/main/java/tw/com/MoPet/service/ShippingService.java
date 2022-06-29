package tw.com.MoPet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.Shipping;
import tw.com.MoPet.model.ShippingRepository;

@Service
@Transactional
public class ShippingService {
	
	@Autowired
	private ShippingRepository ShippingDao;
	
	public List<Shipping> findAll(){
		return ShippingDao.findAll();
	}

}
