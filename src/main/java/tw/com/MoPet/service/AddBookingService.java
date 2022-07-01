package tw.com.MoPet.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.MoPet.model.AddBookingRepository;
import tw.com.MoPet.model.AddBookings;
import tw.com.MoPet.model.AddScheduleRepository;
import tw.com.MoPet.model.AddSchedules;
import tw.com.MoPet.model.employee;
import tw.com.MoPet.model.employeeRepository;

@Service
@Transactional
public class AddBookingService {
	
	@Autowired
	private AddBookingRepository BookingDao;
	@Autowired
	private employeeRepository StaffDao;
	@Autowired
	private AddScheduleRepository ScheduleDao;
	
	
	public List<employee> getAll() {
		return StaffDao.findAll();
	}
	
    public List<AddSchedules> getByName(String staffname) {
		return ScheduleDao.findByStaffname(staffname);
		}
    
    public void insertBooking(AddBookings booking) {
    	    BookingDao.save(booking);
		  }
    
    public List<AddBookings> getByBookday(Date bookday) {
		return BookingDao.findByBookday(bookday);
		}
	
 public AddBookings findById(Long id) {
		
		Optional<AddBookings> optional = BookingDao.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
}
