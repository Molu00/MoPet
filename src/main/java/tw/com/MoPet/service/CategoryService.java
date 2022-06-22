package tw.com.MoPet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.Category;
import tw.com.MoPet.model.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepository CateDao;
	
	public void insertCate(Category category) {
		CateDao.save(category);
	}
	
	public void deleteCate(Category category) {
		CateDao.delete(category);
	}
	
	public List<Category> findAll() {
		return CateDao.findAll();
		
	}
	
	public Category getById(Integer id) {
		Optional<Category> option=CateDao.findById(id) ;
		if(option.isPresent()) {
		return option.get();
			}
		return null;
	}

}
