package tw.com.MoPet.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer>{

	public Comments findFirstByOrderByCreateondateDesc();
	
	public Comments findFirstByOrderByCreateondateAsc();
	
	@Query(value="select id from member where id=:id", nativeQuery=true)
	public Integer findUserId(@Param(value="id") Integer id);
	
	@Query(value = "select * from Comments where title Like %:title%",nativeQuery = true)
	 public List<Comments> findCommentsByStoreNameLike(@Param(value="title")String title);
}
