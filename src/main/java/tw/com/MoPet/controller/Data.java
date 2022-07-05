package tw.com.MoPet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.com.MoPet.model.Category;
import tw.com.MoPet.model.Product;
import tw.com.MoPet.model.birthMonthDTO;
import tw.com.MoPet.model.categoryDTO;
import tw.com.MoPet.model.employee;
import tw.com.MoPet.service.ProductService;
import tw.com.MoPet.service.dataService;
import tw.com.MoPet.service.memberService;

@Controller
public class Data {
	
	@Autowired
	private dataService dService;
	
	@GetMapping(path = "home")
	public String home( Model m, HttpSession session) {
		
		employee emp=(employee)session.getAttribute("backloginOK");
		m.addAttribute("emp", emp);
		
		categoryDTO category=dService.categoryPie();
		m.addAttribute("category",category);
		
		birthMonthDTO birth=dService.birthMonthPie();
		m.addAttribute("birth",birth);
		
		return "BackHome";
	}

}
