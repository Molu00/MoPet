package tw.com.MoPet.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import tw.com.MoPet.model.cart;
import tw.com.MoPet.model.cartitems;
import tw.com.MoPet.model.member;
import tw.com.MoPet.service.CategoryService;
import tw.com.MoPet.service.CompanyService;
import tw.com.MoPet.service.ProductService;
import tw.com.MoPet.service.cartService;
import tw.com.MoPet.service.cartitemsService;
import tw.com.MoPet.service.memberService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private CategoryService cateService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private cartitemsService ciService;
	
	@Autowired
	private cartService cService;
	
	@Autowired
	private memberService mService;
	
	@PostMapping("add/cartItems/{id}")
	public String addCartList(Model modelList,@PathVariable Integer id,HttpSession session) {
		
		//直接抓數值id去DB撈資料，如果照著欄位沒有撈到cart，新建cart
		if(cService.findByMemberId(100)==null) {
		cart newCart=new cart();
		
		member tempMember=mService.findById(100);
		newCart.setFkMemberId(tempMember);
		cService.insertCart(newCart);
		}
		//如果照著欄位有撈到資料，就直接把購物車抓出來
		cart getCart=cService.findByMemberId(100);
		
		
		cartitems items=new cartitems();
		
//		mvc.getModel().put("message", tempPro);

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
