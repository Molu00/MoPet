package tw.com.MoPet.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.com.MoPet.model.Comments;
import tw.com.MoPet.service.CommentsService;
import tw.com.MoPet.service.RepliesService;

@Controller

public class CommentsController {

	@Autowired
	private CommentsService cService;

	@Autowired
	private RepliesService rService;

//	@GetMapping("comments/findAll")
//	@ResponseBody
//	public List<Comments> findAll() {
//		return cService.findAll();
//	}

	@PostMapping("comments/add") // post送出資料
	public String addComment(@ModelAttribute("comments") Comments comments,
			@RequestParam("comimg") MultipartFile file) throws IOException {

		if (!file.isEmpty()) {
			String temp = new String(Base64.getEncoder().encode(file.getBytes()));
			String profile = "data:image/png;base64," + temp;

			comments.setCom_img(profile);
		}

		cService.insertComment(comments);

		return "redirect:/comments/all";
	}

	@GetMapping("comments/edit")
	public String editComment(@RequestParam("id") Integer id, Model model) {

		Comments comments = cService.findById(id);

		model.addAttribute("commemts", comments);

		return "editComments";
	}

	@PostMapping("comments/edit")
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

		return "redirect:/comments/all";
	}

	@GetMapping("comments/delete")
	public String deleteComment(@RequestParam("id") Integer id) {

		cService.deleteComment(id);

		return "redirect:/comments/all";
	}


//	@GetMapping(path = "replies/count")
//	public String countReplies(@RequestParam("fk_c_id") Integer id) {
//
//		Integer count = rService.countReplies(id);
//		System.out.println(count);
//
//		return "allComments";
//	}
	
	
}
