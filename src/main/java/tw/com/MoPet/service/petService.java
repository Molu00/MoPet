package tw.com.MoPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.pet;
import tw.com.MoPet.model.petRepository;

@Service
@Transactional
public class petService {

	@Autowired
	private petRepository petDao;
	
	public pet insert(pet pet) {
		pet tpet=petDao.save(pet);
		return tpet;
	}
	
	public void delete(pet pet) {
		petDao.delete(pet);	
	}

}
