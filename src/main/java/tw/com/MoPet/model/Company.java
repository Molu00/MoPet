package tw.com.MoPet.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="companyid")
	private Integer companyid;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "companyid",cascade = CascadeType.ALL)
	private Set<Product> products=new LinkedHashSet<Product>();
	
	@Column(name="company")
	private String company;
	@Column(name="cPhone")
	private String cPhone;
	@Column(name="cAddress")
	private String cAddress;
	@Column(name="cEmail")
	private String cEmail;
	@Column(name="cLogo")
	private String cLogo;
	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") // Spring MVC 用
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="cAdded", columnDefinition="datetime") // 預設是 datetime2
//	private Date cAdded;
//	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") // Spring MVC 用
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="cUpdate", columnDefinition="datetime") // 預設是 datetime2
//	private Date cUpdate;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcLogo() {
		return cLogo;
	}

	public void setcLogo(String cLogo) {
		this.cLogo = cLogo;
	}

//	public Date getcAdded() {
//		return cAdded;
//	}
//
//	public void setcAdded(Date cAdded) {
//		this.cAdded = cAdded;
//	}
//
//	public Date getcUpdate() {
//		return cUpdate;
//	}
//
//	public void setcUpdate(Date cUpdate) {
//		this.cUpdate = cUpdate;
//	}

}
