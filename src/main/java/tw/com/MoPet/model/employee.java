package tw.com.MoPet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="employee")
public class employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer empId;
	
	@Column(name="emp_role")
	private String empRole;
	
	@Column(name="emp_email")
	private String empEmail;
	
	@Column(name="emp_pwd")
	private String empPwd;
	
	@Column(name="emp_profile")
	private String empProfile;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") // Spring MVC 用
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="emp_startDate", columnDefinition="datetime") // 預設是 datetime2
	private Date empStartDate;
	
	@Column(name="emp_tel")
	private String empTel;
	
	@Column(name="emp_name")
	private String empName;

	public employee() {
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpProfile() {
		return empProfile;
	}

	public void setEmpProfile(String empProfile) {
		this.empProfile = empProfile;
	}

	public Date getEmpStartDate() {
		return empStartDate;
	}

	public void setEmpStartDate(Date empStartDate) {
		this.empStartDate = empStartDate;
	}

	public String getEmpTel() {
		return empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("employee [empId=");
		builder.append(empId);
		builder.append(", empRole=");
		builder.append(empRole);
		builder.append(", empEmail=");
		builder.append(empEmail);
		builder.append(", empPwd=");
		builder.append(empPwd);
		builder.append(", empProfile=");
		builder.append(empProfile);
		builder.append(", empStartDate=");
		builder.append(empStartDate);
		builder.append(", empTel=");
		builder.append(empTel);
		builder.append(", empName=");
		builder.append(empName);
		builder.append("]");
		return builder.toString();
	}


}
