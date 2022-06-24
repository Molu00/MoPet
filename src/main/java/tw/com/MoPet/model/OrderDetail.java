package tw.com.MoPet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="orderDetail")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderDetailId")
	private Integer orderDetailId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_order_id")
	private Order orderId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_cart_id")
	private Cart cartid;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") // Spring MVC 用
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="orderdetail_added", columnDefinition="datetime") // 預設是 datetime2
	private Date orderdetailAdded;

	// 檢查是否有時間，沒有的話依照現在時間產生
	@PrePersist // helper function 在物件轉換成 Persistent 狀態以前，做此方法
	public void onCreate() {
		if(orderdetailAdded == null) {
			this.orderdetailAdded = new Date();
		}
	}
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	public Cart getCartid() {
		return cartid;
	}

	public void setCartid(Cart cartid) {
		this.cartid = cartid;
	}

	public Date getOrderdetailAdded() {
		return orderdetailAdded;
	}

	public void setOrderdetailAdded(Date orderdetailAdded) {
		this.orderdetailAdded = orderdetailAdded;
	}

}
