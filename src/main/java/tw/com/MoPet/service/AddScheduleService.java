package tw.com.MoPet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.AddScheduleRepository;
import tw.com.MoPet.model.AddSchedules;

@Service
@Transactional
public class AddScheduleService {
	
	 @Autowired
	 private  AddScheduleRepository scheduleDao;
	 
	 public void insertSchedule(AddSchedules schedule) {
		   scheduleDao.save(schedule);
		  }
	 
	 public List<AddSchedules> getByName(String staffname) {
			return scheduleDao.findByStaffname(staffname);
		}
	 
	 public Page<AddSchedules> findByPage(Integer pageNumber){
			Pageable pgb = PageRequest.of(pageNumber-1, 30 ,Sort.Direction.ASC ,"id");
			
			Page<AddSchedules> page = scheduleDao.findAll(pgb);
			
			return page;
			
		}

}