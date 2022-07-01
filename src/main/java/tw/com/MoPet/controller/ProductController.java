package tw.com.MoPet.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tw.com.MoPet.model.Category;
import tw.com.MoPet.model.Company;
import tw.com.MoPet.model.Product;
import tw.com.MoPet.service.CategoryService;
import tw.com.MoPet.service.CompanyService;
import tw.com.MoPet.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private CategoryService cateService;
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("offsold/product/{id}")
	public String offSold(@PathVariable Integer id) {
		Product product=pService.getById(id);
		product.setSold(false);
		pService.insertProduct(product);
		return "redirect:/all/products";
		
	}
	
	@GetMapping("onsold/product/{id}")
	public String onSold(@PathVariable Integer id) {
		Product product=pService.getById(id);
		product.setSold(true);
		pService.insertProduct(product);
		return "redirect:/all/products";
		
	}
	
	@GetMapping("add/products")
	public ModelAndView returnSelectList(ModelAndView mvc) {
		List<Category> cateList=cateService.findAll();
		List<Company> companyList=companyService.findAll();
		mvc.getModel().put("catelist", cateList);
		mvc.getModel().put("companyList", companyList);
		mvc.setViewName("insertProduct");
		return mvc;
	}
	
	@GetMapping("edit/product/{id}")
	public ModelAndView editProduct(ModelAndView mvc,@PathVariable Integer id) {
		Product product=pService.getById(id);
		List<Category> cateList=cateService.findAll();
		List<Company> companyList=companyService.findAll();
		mvc.getModel().put("catelist", cateList);
		mvc.getModel().put("companyList", companyList);
		mvc.getModel().put("product", product);
		mvc.setViewName("editProduct");
		return mvc;
	}
	
	@PostMapping("editProduct")
	public String editMassage(@ModelAttribute Product pdt,@RequestParam("tempFile") MultipartFile file) throws Exception {
		
		Date now = pService.getTimeNow();
		pdt.setpAdded(now);
		
		if(file.isEmpty()) {
			Product product=pService.getById(pdt.getpId());
			pdt.setpImg(product.getpImg());
		}
		else {
			String base64Str= pService.getBase64(file);
			pdt.setpImg(base64Str);
		}
		
		pService.insertProduct(pdt);
		
		return "redirect:/all/products";
	}
	
	@GetMapping("delete/product/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		System.out.println("=========================================== ++ "+id);
		pService.deleteProduct(id);
		return "redirect:/all/products";
	}
	
	@PostMapping("insertProduct")
	public String insertProduct(@ModelAttribute Product pdt,@RequestParam("tempFile") MultipartFile file) throws Exception {
		
		if(file.isEmpty()) {
			pdt.setpImg(pService.getDefaultimg());
		}
		else {
			String base64Str= pService.getBase64(file);
			pdt.setpImg(base64Str);
		}
		
		pService.insertProduct(pdt);
		return "redirect:/all/products";
	}
}
