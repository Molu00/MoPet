//package tw.com.MoPet.controller;
//
//import java.io.IOException;
//import java.util.Base64;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import tw.com.MoPet.model.Comments;
//import tw.com.MoPet.model.Replies;
//import tw.com.MoPet.service.CommentsService;
//import tw.com.MoPet.service.RepliesService;
//
//@Controller
//public class FormController {
//
//	@Autowired
//	private CommentsService cService;
//	
//	@Autowired
//	private RepliesService rService;
//	
//
//	@PostMapping("comments/add") // post送出資料
//	public String addComment(@ModelAttribute("comments") Comments comments, Model model,
//			@RequestParam("comimg") MultipartFile file) throws IOException {
//
//		if (!file.isEmpty()) {
//			String temp = new String(Base64.getEncoder().encode(file.getBytes()));
//			String profile = "data:image/png;base64," + temp;
//
//			comments.setCom_img(profile);
//		}
//
//		cService.insertComment(comments);
//
//		Comments newcomment = new Comments();
//
//		Comments lastest = cService.getLastest();
//
//		model.addAttribute("comments", newcomment);
//		model.addAttribute("lastest", lastest);
//
//		return "redirect:/comments/all";
//	}
//
//	@GetMapping("comments/edit")
//	public String editComment(@RequestParam("id") Integer id, Model model) {
//
//		Comments comment = cService.findById(id);
//
//		model.addAttribute("commemt", comment);
//
//		return "editComments";
//	}
//
//	@PostMapping("comments/edit")
//	public String postEditComments(@ModelAttribute(name = "comment") Comments comment,
//			@RequestParam("comimg") MultipartFile file) throws IOException {
//
//		if (file.isEmpty()) {
//			comment.getId();
//			Comments com = cService.findById(comment.getId());
//			comment.setCom_img(com.getCom_img());
//		} else {
//			String temp = new String(Base64.getEncoder().encode(file.getBytes()));
//			String profile = "data:image/png;base64," + temp;
//
//			comment.setCom_img(profile);
//		}
//
//		// 取得現在時間
//		Date now = Calendar.getInstance().getTime();
//
//		comment.setCreateondate(now);
//
//		cService.insertComment(comment);
//
//		return "redirect:/comments/all";
//	}
//
//	@GetMapping("comments/add")
//	public String addComment(Model model) {
//
//		Comments comments = new Comments();
//
//		Comments lastest = cService.getLastest();
//
//		model.addAttribute("comments", comments);
//		model.addAttribute("lastest", lastest);
//
//		return "addComment";
//
//	}
//
//	// 取的分頁
//	@GetMapping("comments/all")
//	public String viewtext(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
//
//		Page<Comments> page = cService.findByPage(pageNumber);
//
//		model.addAttribute("page", page);
//
//		return "allComments";
//	}
//
//	@GetMapping("comments/page")
//	public String pagechange(@RequestParam("id") Integer id, Model model) {
//
//		Comments com = cService.findById(id);
//		List<Replies> fk = rService.findByFk(id);
//		Integer count = rService.countReplies(id);
//
////				System.out.println(fk);
//
//		model.addAttribute("com", com);
//		model.addAttribute("fk", fk);
//		model.addAttribute("count", count);
//
//		return "pageChange";
//
//	}
//
//	@GetMapping("comments/delete")
//	public String deleteComment(@RequestParam("id") Integer id) {
//
//		cService.deleteComment(id);
//
//		return "redirect:/comments/all";
//	}
//
//	
//	@PostMapping("replies/add") // post送出資料
//	public String addReplies(@ModelAttribute("replies") Replies replies, Model model,@RequestParam("repimg")MultipartFile file,@RequestParam("id")Integer id) throws IOException {
//		
//		if (!file.isEmpty()) {
//		String temp = new String(Base64.getEncoder().encode(file.getBytes()));
//		String profile = "data:image/png;base64," + temp;
//		
//		replies.setRep_img(profile);
//		}
//		
//		Comments com=cService.findById(id);
//		
//		replies.setComments(com);
//		
//		rService.insertReplies(replies);
//		
//		Replies newReplies = new Replies();
//
//		Replies lastest = rService.getLastest();
//
//		model.addAttribute("replies", newReplies);
//		model.addAttribute("lastest", lastest);
//		
//		String url = "redirect:http://localhost:8080/MoPet/comments/page?id=" + id;
//		
//		return url;
//	}
//
//	@GetMapping("replies/edit")
//	public String editReplies(@RequestParam("id") Integer id, Model model) { // 回覆ID
//		Replies replies = rService.findById(id);
//
//		model.addAttribute("replies", replies);
//		return "editReplies";
//	}
//
//	@PostMapping("replies/edit")
//	public String postEditReplies(@ModelAttribute(name = "replies") Replies replies, @RequestParam("id") Integer id) {
//
//		// 取得現在時間
//		Date now = Calendar.getInstance().getTime();
//
//		Optional<Replies> res = rService.findByid(id);
//
//		res.get().setCreateondate(now);
//		res.get().setContent(replies.getContent());
//		rService.insertReplies(res.get());
//
//		Integer one = res.get().getId();
//		Integer test = rService.getFKID(one);
//
//		String url = "redirect:http://localhost:8080/MoPet/comments/page?id=" + test; // OK了
//
//		return url;
//	}
//
//	@GetMapping("replies/delete")
//	public String deleteReplies(@RequestParam("id") Integer id, @RequestParam("c_id") Integer c_id) {
//
//		rService.deleteReplies(id);
//
//		String url = "redirect:http://localhost:8080/MoPet/comments/page?id=" + c_id;
//
//		return url;
//	}
//	
//	@GetMapping("replies/add")
//	public String addReplies(Model model,@RequestParam("id")Integer id) {
//		
//		Replies replies = new Replies();
//		
//		replies.setFk_c_id(id);
//		
//		model.addAttribute("replies", replies); 
//	
//		return "addReplies";
//		
//	}
//	
//	@GetMapping("replies/all")
//	public String viewtext2(@RequestParam(name="p" ,defaultValue="1") Integer pageNumber,Model model) {
//		Page<Replies> page = rService.findByPage(pageNumber);
//		
//		model.addAttribute("page", page);
//		
//		return "allReplies";
//	}
//}
