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
@Table(name="order")
public class order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderId")
	private Integer orderId;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "orderId",cascade = CascadeType.ALL)
	private Set<orderdetail> orderdetail=new LinkedHashSet<orderdetail>();
	
	@Column(name="orderTotal")
	private Integer orderTotal;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") // Spring MVC 用
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="orderAdded", columnDefinition="datetime") // 預設是 datetime2
	private Date orderAdded;
	
	@Column(name="shippingAddress")
	private String shippingAddress;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_member_id")
	private member fkMemberId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_payment_id")
	private payment paymentId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_shipping_id")
	private shipping shippingId;
	
	@Column(name="shippingStatus")
	private boolean shippingStatus;
	
	@Column(name="paymentStatus")
	private boolean paymentStatus;
	
	// 檢查是否有時間，沒有的話依照現在時間產生
				@PrePersist // helper function 在物件轉換成 Persistent 狀態以前，做此方法
				public void onCreate() {
					if(orderAdded == null) {
						this.orderAdded = new Date();
					}
				}
	
	public order() {
		// TODO Auto-generated constructor stub
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Integer orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public member getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(member fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public payment getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(payment paymentId) {
		this.paymentId = paymentId;
	}

	public shipping getShippingId() {
		return shippingId;
	}

	public void setShippingId(shipping shippingId) {
		this.shippingId = shippingId;
	}

	public boolean isShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(boolean shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
