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
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartId")
	private Integer cartId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_member_id")
	private member fkMemberId;
	
	@JoinColumn(name="cartStatus")
	private boolean cartStatus;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cartId",cascade = CascadeType.ALL)
	private Set<CartItems> cartitems=new LinkedHashSet<CartItems>();
	
	
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") // Spring MVC 用
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cartAdded", columnDefinition="datetime") // 預設是 datetime2
	private Date cartAdded;
	
	// 檢查是否有時間，沒有的話依照現在時間產生
			@PrePersist // helper function 在物件轉換成 Persistent 狀態以前，做此方法
			public void onCreate() {
				if(cartAdded == null) {
					this.cartAdded = new Date();
				}
			}
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public member getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(member fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public Date getCartAdded() {
		return cartAdded;
	}

	public void setCartAdded(Date cartAdded) {
		this.cartAdded = cartAdded;
	}

	public Set<CartItems> getCartitems() {
		return cartitems;
	}

	public void setCartitems(Set<CartItems> cartitems) {
		this.cartitems = cartitems;
	}

	public boolean isCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(boolean cartStatus) {
		this.cartStatus = cartStatus;
	}

}
