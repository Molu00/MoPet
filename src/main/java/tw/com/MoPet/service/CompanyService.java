package tw.com.MoPet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.Company;
import tw.com.MoPet.model.CompanyRepository;

@Service
@Transactional
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyDao;
	
	public void insertCompanyDao(Company company) {
		companyDao.save(company);
	}
	
	public Company getById(Integer id) {
		Optional<Company> option=companyDao.findById(id);
		companyDao.findById(id);
		if(option.isPresent()) {
		return option.get();
			}
		return null;
	}
	
	public void deleteMessage(Integer id) {
		companyDao.deleteById(id);
	}
	
	public List<Company> findAll() {
		return companyDao.findAll();
		
	}
	
//	public Page<Company> findByPage(Integer companyPageNumber){
//		PageRequest pgb=PageRequest.of(companyPageNumber-1,3,Sort.Direction.DESC,"cAdded");
//		Page<Company> page=companyDao.findAll(pgb);
//		return page;
//	}

}
