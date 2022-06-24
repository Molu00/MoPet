package tw.com.MoPet.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface cartitemsRepository extends JpaRepository<CartItems, Integer> {

	@Query(value="select SUM(cartItemsAmount),fk_product_id from cartItems where fk_cart_id=?1 group by fk_product_id", nativeQuery=true)
	public List<CartItems> findGourpById(Integer id);
	
}
