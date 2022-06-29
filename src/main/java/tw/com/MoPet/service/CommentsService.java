package tw.com.MoPet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.Comments;
import tw.com.MoPet.model.CommentsRepository;

@Service
@Transactional
public class CommentsService {

	@Autowired
	private CommentsRepository cDao;
	
	
	//新增留言
	public void insertComment(Comments comments) {
		cDao.save(comments);
	}
	
	
	public Comments findById(Integer id) {
		
		Optional<Comments> optinal = cDao.findById(id);
		
		if(optinal.isPresent()) {
			return optinal.get();
		}
		return null;
	}
	
	//時間
	public Comments showTime() {
		 return cDao.findFirstByOrderByCreateondateDesc();
	}
	
	public List<Comments> getAllComments(List<Comments> comments) {
		return cDao.saveAll(comments);
	}
	
	//分頁
	public Page<Comments> findByPage(Integer pageNumber){
		
		PageRequest pgb = PageRequest.of(pageNumber-1, 6, Sort.Direction.DESC, "createondate");
		Page<Comments> page = cDao.findAll(pgb);
		
		return page;
	}
	
	
	public void deleteComment(Integer id) {
		
		cDao.deleteById(id);
	}
	
	
	public Comments getLastest() {
		return cDao.findFirstByOrderByCreateondateDesc();
	}
	
	public List<Comments> findAll(){
		return cDao.findAll();
	}
	
	
}

