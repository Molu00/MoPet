package tw.com.MoPet.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productid")
	private Integer pId;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "pId",cascade = CascadeType.ALL)
	private Set<CartItems> cartItemsId=new LinkedHashSet<CartItems>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_company_id")
	private Company companyid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_category_id")
	private Category catid;
	
	@Column(name="pName")
	private String pName;
	@Column(name="pPrice")
	private Integer pPrice;
	@Column(name="gCost")
	private Integer pCost;
	@Column(name="gStock")
	private Integer pStock;
	@Column(name="pImg")
	private String pImg;
	@Column(name="sold")
	private boolean sold;
		
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") // Spring MVC 用
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pAdded", columnDefinition="datetime") // 預設是 datetime2
	private Date pAdded;

	// 檢查是否有時間，沒有的話依照現在時間產生
		@PrePersist // helper function 在物件轉換成 Persistent 狀態以前，做此方法
		public void onCreate() {
			if(pAdded == null) {
				this.pAdded = new Date();
			}
		}
	
	public Product() {
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Company getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Company companyid) {
		this.companyid = companyid;
	}

	public Category getCatid() {
		return catid;
	}

	public void setCatid(Category catid) {
		this.catid = catid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getpPrice() {
		return pPrice;
	}

	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}

	public Integer getpCost() {
		return pCost;
	}

	public void setpCost(Integer pCost) {
		this.pCost = pCost;
	}

	public Integer getpStock() {
		return pStock;
	}

	public void setpStock(Integer pStock) {
		this.pStock = pStock;
	}

	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}

	public Date getpAdded() {
		return pAdded;
	}

	public void setpAdded(Date pAdded) {
		this.pAdded = pAdded;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

}

