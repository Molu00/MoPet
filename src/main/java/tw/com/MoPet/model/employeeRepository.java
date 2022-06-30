package tw.com.MoPet.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<employee, Integer> {
	
	@Query("from employee where empEmail=:empEmail and empPwd=:empPwd")
	public employee findByNameAndPwd(String empEmail, String empPwd);
	
	@Query("from employee where empEmail=:email")
	public employee findByAccount(String email);

}
