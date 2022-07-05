package tw.com.MoPet.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface memberRepository extends JpaRepository<member, Integer> {

	@Query("from member where memberEmail=:memEmail and memberPwd=:memPwd")
	public member findByNameAndPwd(String memEmail, String memPwd);
	
	@Query("from member where member_email=:email")
	public member findByAccount(String email);
	
	@Query("select e from member e where month(e.memberBirth) = :month")
	List<member> getByBirthMonth(Integer month);
}
