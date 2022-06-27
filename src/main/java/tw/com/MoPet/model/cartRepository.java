package tw.com.MoPet.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface cartRepository extends JpaRepository<Cart, Integer> {
	
	public Cart findByFkMemberId(member id);
	
//	@Query(value="select cartId from cart where fk_member_id=:id", nativeQuery=true)
//	public Integer findCartIdByfkMemberId(Integer id);
	
	@Query(value = "select * from Cart a where a.fk_member_id = ?1", nativeQuery=true)
	public Optional<Cart> testMember(Integer id);
	
}
