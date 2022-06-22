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
@Table(name="category")
public class Category {

	@Id
	@Column(name="categoryid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryid;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "catid",cascade = CascadeType.ALL)
	private Set<Product> products=new LinkedHashSet<Product>();
	
	@Column(name="cname")
	private String categoryName;
	
	public Category() {
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
