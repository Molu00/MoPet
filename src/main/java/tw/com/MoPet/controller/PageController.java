package tw.com.MoPet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tw.com.MoPet.model.Comments;
import tw.com.MoPet.model.Order;
import tw.com.MoPet.model.Product;
import tw.com.MoPet.model.Replies;
import tw.com.MoPet.model.employee;
import tw.com.MoPet.service.CommentsService;
import tw.com.MoPet.service.OrderService;
import tw.com.MoPet.service.ProductService;
import tw.com.MoPet.service.RepliesService;
import tw.com.MoPet.service.employeeService;

@Controller
public class PageController {

	@Autowired
	public CommentsService cService;
	
	@Autowired
	public RepliesService rService;
	
	@Autowired

	private employeeService empService;

	public OrderService oService;

	
//	@Autowired
//	public comments_count comments_count;
	
//	@GetMapping("/")
//	public String index() {
//		return"index";
//	}

//	@GetMapping("comments/all")
//	public String allComments() {
//		return"allComments";
//	}
	
	@GetMapping("comments/add")
	public String addComment(Model model) {
		
		Comments comments = new Comments();
		
		Comments lastest = cService.getLastest();
		
		model.addAttribute("comments", comments);
		model.addAttribute("lastest", lastest);
		
		return "addComment";
		
	}
	
	@GetMapping("replies/add")
	public String addReplies(Model model,@RequestParam("id")Integer id) {
		
		Replies replies = new Replies();
		
		replies.setFk_c_id(id);
		
		model.addAttribute("replies", replies); 
	
		return "addReplies";
		
	}
	
	//取的分頁
		@GetMapping("comments/all")
		public String viewtext(@RequestParam(name="p" ,defaultValue="1") Integer pageNumber,Model model) {
			
			Page<Comments> page = cService.findByPage(pageNumber);
			Map<Integer, Integer> map= new HashMap<>();
			for (int i = 0; i < page.getSize()-1; i++) {
			Integer number=rService.countReplies(page.getContent().get(i).getId());
			map.put(page.getContent().get(i).getId(), number);
			}
			
			model.addAttribute("map",map);
			model.addAttribute("page", page);
			
			return "allComments";
		}
		
		@GetMapping("comments/all4")
		public String viewtext3(@RequestParam(name="p" ,defaultValue="1") Integer pageNumber,Model model) {
			
			Page<Comments> page = cService.findByPage2(pageNumber);
					
			model.addAttribute("page", page);
			
			return "allComments";
		}
		
		@GetMapping("replies/all")
		public String viewtext2(@RequestParam(name="p" ,defaultValue="1") Integer pageNumber,Model model) {
			Page<Replies> page = rService.findByPage(pageNumber);
			
			model.addAttribute("page", page);
			
			return "allReplies";
		}
		
		@GetMapping("comments/page")
		public String pagechange(@RequestParam("id")Integer id,Model model) {
			
			Comments com = cService.findById(id);
			List<Replies> fk = rService.findByFk(id);
			Integer count = rService.countReplies(id);
			
//			System.out.println(fk);
			
			model.addAttribute("com", com);
			model.addAttribute("fk", fk);
			model.addAttribute("count", count);
					
			return "pageChange";
			
		}
		
	
//	@GetMapping("comments/all")
//	public ModelAndView viewComments(ModelAndView mav, 
//			@RequestParam(name="p", defaultValue = "1") Integer pageNumber) {
//		Page<Comments> page = cService.findByPage(pageNumber);
//		
//		mav.getModel().put("page", page);
//		mav.setViewName("allComments");
//		return mav;
//	}
	
		@Autowired
		private ProductService pService;
		
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		@GetMapping("/testIndex")
		public String testIndex() {
			return "testIndex";
		}
		
		@GetMapping("backend")
		public String backend() {
			return "background";
		}
		
		@GetMapping("shop/products")
		public ModelAndView shopProductList(ModelAndView mvc) {
			List<Product> productList=pService.findAll();
			
			mvc.getModel().put("productList",productList);
			mvc.setViewName("shop");
			return mvc;
		}
		
		@GetMapping("all/products")
		public ModelAndView allProductList(ModelAndView mvc, @RequestParam(value = "p",defaultValue = "1") Integer pageNumber) {
			
			Page<Product> page=pService.findByPage(pageNumber);
//			List<Product> productList=pService.findAll();
			
//			mvc.getModel().put("productList",productList);
			mvc.getModel().put("productList",page);
			mvc.setViewName("viewProducts");
			return mvc;
		}
		
		@GetMapping("cart/ItemsEmpty")
		public String cartItemEmpty() {
			return "cartItemsEmpty";
		}
		

		@GetMapping("staff/all")
		public ModelAndView viewStaffs(ModelAndView mav,
				@RequestParam(name = "p", defaultValue = "1") Integer pageNumber) {
			Page<employee> page = empService.findByPage(pageNumber);

			mav.getModel().put("page", page);
			mav.setViewName("viewStaffs");
			return mav;

		@GetMapping("all/orders")
		public ModelAndView allOrderList(ModelAndView mvc, @RequestParam(value = "p",defaultValue = "1") Integer pageNumber) {
			
			Page<Order> page=oService.findByPage(pageNumber);
//			List<Product> productList=pService.findAll();
			
//			mvc.getModel().put("productList",productList);
			mvc.getModel().put("orderList",page);
			mvc.setViewName("viewOrder");
			return mvc;

		}
	
}
