package tw.com.MoPet.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value="select * from product where fk_category_id=?1", nativeQuery=true)
	public List<Product> findByCategoryId(Integer categoryId);
	
}
