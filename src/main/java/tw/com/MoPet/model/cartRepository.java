package tw.com.MoPet.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface cartRepository extends JpaRepository<cart, Integer> {
	public cart findByfkMemberId(Integer id);
}
