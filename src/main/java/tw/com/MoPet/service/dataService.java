package tw.com.MoPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.birthMonthDTO;
import tw.com.MoPet.model.categoryDTO;

@Service
@Transactional
public class dataService {
	@Autowired
	private ProductService pService;

	@Autowired
	private memberService mService;
	
	
	public categoryDTO categoryPie() {
		Integer numF= pService.findByCategory(1).size();
		Integer numT= pService.findByCategory(2).size();
		Integer numcl= pService.findByCategory(3).size();
		Integer numS= pService.findByCategory(4).size();
		Integer numC= pService.findByCategory(5).size();
		categoryDTO category=new categoryDTO();
		category.setFoods(numF);
		category.setToys(numT);
		category.setClothing(numcl);
		category.setSupplies(numS);
		category.setCleaning(numC);
		
		return category;
	}
	
	public birthMonthDTO birthMonthPie() {
		Integer numJ=mService.getByBirthMonth(1).size();
		Integer numF=mService.getByBirthMonth(2).size();
		Integer numM=mService.getByBirthMonth(3).size();
		Integer numA=mService.getByBirthMonth(4).size();
		Integer numMay=mService.getByBirthMonth(5).size();
		Integer numJune=mService.getByBirthMonth(6).size();
		Integer numJuly=mService.getByBirthMonth(7).size();
		Integer numAu=mService.getByBirthMonth(8).size();
		Integer numS=mService.getByBirthMonth(9).size();
		Integer numO=mService.getByBirthMonth(10).size();
		Integer numN=mService.getByBirthMonth(11).size();
		Integer numD=mService.getByBirthMonth(12).size();
		
		birthMonthDTO birth=new birthMonthDTO();
		birth.setJanuary(numJ);
		birth.setFebruary(numF);
		birth.setMarch(numM);
		birth.setApril(numA);
		birth.setMay(numMay);
		birth.setJune(numJune);
		birth.setJuly(numJuly);
		birth.setAugust(numAu);
		birth.setSeptember(numS);
		birth.setOctober(numO);
		birth.setNovember(numN);
		birth.setDecember(numD);
		
		System.out.println(birth.toString());
		return birth;
	}
}
