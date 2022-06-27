package tw.com.MoPet.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepliesRepository extends JpaRepository<Replies,Integer>{



	public Replies findFirstByOrderByCreateondateDesc();
	
	@Query(value="select count(*) from Replies where fk_c_id=:id",nativeQuery=true)
	public Integer countReplies(Integer id);

	@Query(value="select * from Replies where fk_c_id=:id",nativeQuery=true)
	public List<Replies> findByFFk(Integer id);
	
	@Query(value="select fk_c_id from Replies where id=:id", nativeQuery=true)
	public Integer findFKID(Integer id);
	
}
