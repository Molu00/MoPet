package tw.com.MoPet.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.com.MoPet.model.Comments;
import tw.com.MoPet.model.Replies;
import tw.com.MoPet.service.CommentsService;
import tw.com.MoPet.service.RepliesService;

@Controller
public class FrontCommentsController {

	@Autowired
	private CommentsService cService;
	
	@Autowired
	private RepliesService rService;
	
	
	@GetMapping("comments/all2")
	public String viewtext(@RequestParam(name="p" ,defaultValue="1") Integer pageNumber,Model model) {
		
		Page<Comments> page = cService.findByPage(pageNumber);
				
		model.addAttribute("page", page);
		
		return "allComments2";
	}
	
	@GetMapping("comments/all3")
	public String viewtext2(@RequestParam(name="p" ,defaultValue="1") Integer pageNumber,Model model) {
		
		Page<Comments> page = cService.findByPage2(pageNumber);
				
		model.addAttribute("page", page);
		
		return "allComments2";
	}
	
	@GetMapping("comments/add2")
	public String addComment(Model model) {
		
		Comments comments = new Comments();
		
		Comments lastest = cService.getLastest();
		
		model.addAttribute("comments", comments);
		model.addAttribute("lastest", lastest);
		
		return "addComment2";
		
	}
	
	@GetMapping("comments/edit2")
	public String editComment(@RequestParam("id") Integer id, Model model) {

		Comments comments = cService.findById(id);

		model.addAttribute("commemts", comments);

		return "editComments2";
	}
	
	@PostMapping("comments/edit2")
	public String postEditComments(@ModelAttribute(name = "comment") Comments comment,
			@RequestParam("comimg") MultipartFile file) throws IOException {

		if (file.isEmpty()) {
			comment.getId();
			Comments com = cService.findById(comment.getId());
			comment.setCom_img(com.getCom_img());
		} else {
			String temp = new String(Base64.getEncoder().encode(file.getBytes()));
			String profile = "data:image/png;base64," + temp;

			comment.setCom_img(profile);
		}

		// 取得現在時間
		Date now = Calendar.getInstance().getTime();

		comment.setCreateondate(now);

		cService.insertComment(comment);

		return "redirect:/comments/all2";
	}
	
	@GetMapping("comments/page2")
	public String pagechange(@RequestParam("id")Integer id,Model model) {
		
		Comments com = cService.findById(id);
		List<Replies> fk = rService.findByFk(id);
		Integer count = rService.countReplies(id);
		
//		System.out.println(fk);
		
		model.addAttribute("com", com);
		model.addAttribute("fk", fk);
		model.addAttribute("count", count);
				
		return "pageChange2";
		
	}
	
	@PostMapping("comments/add2") // post送出資料
	public String addComment(@ModelAttribute("comments") Comments comments,
			@RequestParam("comimg") MultipartFile file) throws IOException {

		if (!file.isEmpty()) {
			String temp = new String(Base64.getEncoder().encode(file.getBytes()));
			String profile = "data:image/png;base64," + temp;

			comments.setCom_img(profile);
		}

		cService.insertComment(comments);

		return "redirect:/comments/all2";
	}
	
	@GetMapping("comments/delete2")
	public String deleteComment(@RequestParam("id") Integer id) {

		cService.deleteComment(id);

		return "redirect:/comments/all2";
	}
	
	@GetMapping("replies/add2")
	public String addReplies(Model model,@RequestParam("id")Integer id) {
		
		Replies replies = new Replies();
		
		replies.setFk_c_id(id);
		
		model.addAttribute("replies", replies); 
	
		return "addReplies2";
		
	}
	
	
	@PostMapping("replies/add2") // post送出資料
	public String addReplies(@ModelAttribute("replies") Replies replies, Model model,
			@RequestParam("repimg") MultipartFile file, @RequestParam("id") Integer id) throws IOException {

		if (!file.isEmpty()) {
			String temp = new String(Base64.getEncoder().encode(file.getBytes()));
			String profile = "data:image/png;base64," + temp;

			replies.setRep_img(profile);
		}

		Comments com = cService.findById(id);

		replies.setComments(com);

		rService.insertReplies(replies);
		
		Replies newReplies = new Replies();  

		Replies lastest = rService.getLastest();

		model.addAttribute("replies", newReplies);
		model.addAttribute("lastest", lastest);


		String url = "redirect:http://localhost:8080/MoPet/comments/page2?id=" + id;

		return url;
	}
	
	@GetMapping("replies/edit23")
	public String editReplies(@RequestParam("id") Integer id, Model model) { // 回覆ID
		
		Replies replies = rService.findById(id);

		model.addAttribute("replies", replies);
		
		return "editReplies2";
	}
	
	@PostMapping("replies/edit23")
	public String postEditReplies(@ModelAttribute(name = "replies") Replies replies, @RequestParam("id") Integer id,
			@RequestParam("repimg") MultipartFile file) throws IOException {

		if (file.isEmpty()) {
			replies.getId();
			Replies com = rService.findById(replies.getId());
			replies.setRep_img(com.getRep_img());
		} else {
			String temp = new String(Base64.getEncoder().encode(file.getBytes()));
			String profile = "data:image/png;base64," + temp;

			replies.setRep_img(profile);
		}
		// 取得現在時間
		Date now = Calendar.getInstance().getTime();

		Optional<Replies> res = rService.findByid(id);

		res.get().setCreateondate(now);
		res.get().setContent(replies.getContent());
		rService.insertReplies(res.get());

		Integer one = res.get().getId();
		Integer test = rService.getFKID(one);

		String url = "redirect:http://localhost:8080/MoPet/comments/page2?id=" + test; // OK了

		return url;
	}
	
	@GetMapping("replies/delete2")
	public String deleteReplies(@RequestParam("id") Integer id, @RequestParam("c_id") Integer c_id) {

		rService.deleteReplies(id);

		String url = "redirect:http://localhost:8080/MoPet/comments/page2?id=" + c_id;

		return url;
	}
}
