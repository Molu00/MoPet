package tw.com.MoPet.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query(value = "select * from order_table where fk_member_id=?1 and paymentStatus=?2", nativeQuery = true)
	public Optional<Order> findBymIdAndcStatus(Integer memberId,boolean paymentStatus);
}
