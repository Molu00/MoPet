package tw.com.MoPet.model;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddBookingRepository extends JpaRepository<AddBookings, Long> {
	
	public List<AddBookings> findByBookday(Date bookday);

}

