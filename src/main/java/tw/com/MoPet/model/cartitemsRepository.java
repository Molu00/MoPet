package tw.com.MoPet.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface cartitemsRepository extends JpaRepository<CartItems, Integer> {

//	@Query(value="select SUM(cartItemsAmount),fk_product_id from cartItems where fk_cart_id=?1 group by fk_product_id", nativeQuery=true)
//	public List<CartItems> findGourpById(Integer id);

	@Query(value="select * from cartItems where fk_cart_id=?1", nativeQuery=true)
	public List<CartItems> findItemsList(Integer number);
//	public List<CartItems> findAllByCartId(Integer cartid);
	
	@Query(value="select * from cartItems where fk_product_id=?1 and fk_cart_id=?2", nativeQuery=true)
	public CartItems findItemByProductId(Integer productid,Integer cartid);
	
	@Query(value="delete from cartItems where fk_product_id=?1 and fk_cart_id=?2", nativeQuery=true)
	public void deleteItemByTwoKeys(Integer productid,Integer cartid);
	
	@Query(value="select * from cartItems where fk_cart_id=?1", nativeQuery=true)
	public List<CartItems> findItemByCart(Integer cartid);
	
}
