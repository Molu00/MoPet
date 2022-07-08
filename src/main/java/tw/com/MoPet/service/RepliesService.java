package tw.com.MoPet.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.Replies;
import tw.com.MoPet.model.RepliesRepository;

@Service
@Transactional
public class RepliesService {

	@Autowired
	public RepliesRepository rDao;
	
	
	//新增留言
	public void insertReplies(Replies replies) {
		rDao.save(replies);
	}
	
	//查詢全部留言
	public List<Replies> findAllReplies(){
		return rDao.findAll();
	}
	
	//取得留言數
	public Integer countReplies(Integer id) {
		return rDao.countReplies(id);
	}
	
	//找FK
	public List<Replies> findByFk(Integer id) {
		return rDao.findByFFk(id);
	}
	
	//通過ID找到留言
	public Optional<Replies> findByid(Integer id){
		return rDao.findById(id);
	}
	
	//刪除留言
	public void deleteReplies(Integer id) {
		rDao.deleteById(id);
	}
	
	public Replies findById(Integer id) {
		Optional<Replies> op = rDao.findById(id);
		
		if(op.isPresent()) {
			return op.get();				
		}
		return null;
	}
	
	public Page<Replies> findByPage(Integer pageNumber){
		
		PageRequest pgb = PageRequest.of(pageNumber-1, 100, Sort.Direction.DESC, "createondate");
		Page<Replies> page = rDao.findAll(pgb);
		
		return page;
	}
	
	public Replies getLastest() {
		return rDao.findFirstByOrderByCreateondateDesc();
	}
	
	public Integer getFKID(Integer id) {
		return rDao.findFKID(id);
	}
	
	public Integer findByUserId(Integer id) {
		return rDao.findUserId(id);
	}
	
	public Date getTimeNow() {
		  return Calendar.getInstance().getTime();
		 }
	
}
