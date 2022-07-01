package tw.com.MoPet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_Detail_temp")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderDetailTemp")
	private Integer orderDetailId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_order_id")
	private Order orderId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_product_id")
	private Product pId;
	
	@Column(name="amount")
	private Integer productAmount;
	
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

	public Product getpId() {
		return pId;
	}

	public void setpId(Product pId) {
		this.pId = pId;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

}
