package tw.com.MoPet.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payid")
	private Integer payId;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "paymentId",cascade = CascadeType.ALL)
	private Set<order> orderPayment=new LinkedHashSet<order>();
	
	@Column(name="payway")
	private String paymentWay;
	
	@Column(name="payprice")
	private Integer paymentPrice;
	
	public payment() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPayId() {
		return payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public String getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}

	public Integer getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(Integer paymentPrice) {
		this.paymentPrice = paymentPrice;
	}

	public Set<order> getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(Set<order> orderPayment) {
		this.orderPayment = orderPayment;
	}



}
