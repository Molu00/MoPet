package tw.com.MoPet.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer>{

	public Comments findFirstByOrderByCreateondateDesc();
	
	
}
