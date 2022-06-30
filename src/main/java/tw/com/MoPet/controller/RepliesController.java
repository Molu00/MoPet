package tw.com.MoPet.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.com.MoPet.model.Comments;
import tw.com.MoPet.model.Replies;
import tw.com.MoPet.service.CommentsService;
import tw.com.MoPet.service.RepliesService;

@Controller
public class RepliesController {

	@Autowired
	private RepliesService rService;

	@Autowired
	private CommentsService cService;

//	@GetMapping("replies/findAll")
//	@ResponseBody
//	public List<Replies> findAll() {
//		return rService.findAllReplies();
//	}

//	@GetMapping(path = "replies/count/{fk_c_id}")
//	public String countReplies(@PathVariable("fk_c_id") Integer id) {
//
//		Integer count = rService.countReplies(id);
//		System.out.println(count);
//
//		return "allComments";
//	}

//	@GetMapping("replies/findFk/{id}")
//	@ResponseBody
//	public List<Replies> findByFk(@PathVariable Integer id) {
//		return rService.findByFk(id);
//	}

	@PostMapping("replies/add") // post送出資料
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

//		Replies newReplies = new Replies();  如果留言後停在同一頁 需要再NEW一個新的空頁面 跳轉則不用
//
//		Replies lastest = rService.getLastest();
//
//		model.addAttribute("replies", newReplies);
//		model.addAttribute("lastest", lastest);

		String url = "redirect:http://localhost:8080/MoPet/comments/page?id=" + id;

		return url;
	}

	@GetMapping("replies/edit")
	public String editReplies(@RequestParam("id") Integer id, Model model) { // 回覆ID
		Replies replies = rService.findById(id);

		model.addAttribute("replies", replies);
		return "editReplies";
	}

	@PostMapping("replies/edit")
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

		String url = "redirect:http://localhost:8080/MoPet/comments/page?id=" + test; // OK了

		return url;
	}

	@GetMapping("replies/delete")
	public String deleteReplies(@RequestParam("id") Integer id, @RequestParam("c_id") Integer c_id) {

		rService.deleteReplies(id);

		String url = "redirect:http://localhost:8080/MoPet/comments/page?id=" + c_id;

		return url;
	}

}
