package tw.com.MoPet.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddScheduleRepository extends JpaRepository<AddSchedules, Long> {

	public List<AddSchedules> findByStaffname(String staffname);
	
	public AddSchedules findFirstByOrderByAddedDesc();
}