package tw.com.MoPet.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface memberRepository extends JpaRepository<member, Integer> {

	@Query("from member where memberEmail=:memEmail and memberPwd=:memPwd")
	public member findByNameAndPwd(String memEmail, String memPwd);
}
