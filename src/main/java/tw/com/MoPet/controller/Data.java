package tw.com.MoPet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.com.MoPet.model.Category;
import tw.com.MoPet.model.Product;
import tw.com.MoPet.model.categoryDTO;
import tw.com.MoPet.service.ProductService;

@Controller
public class Data {
	
	@Autowired
	private ProductService pService;
	
	@GetMapping(path = "home")
	public String home( Model m) {
		Integer numF= pService.findByCategory(1).size();
		Integer numT= pService.findByCategory(2).size();
		Integer numcl= pService.findByCategory(3).size();
		Integer numS= pService.findByCategory(4).size();
		Integer numC= pService.findByCategory(5).size();
		
		categoryDTO category=new categoryDTO();
		category.setFoods(numF);
		category.setToys(numT);
		category.setClothing(numcl);
		category.setClothing(numS);
		category.setClothing(numC);
		m.addAttribute("category",category);
		return "BackHome";
	}

}
