package tw.com.MoPet.model;

import java.util.LinkedHashMap;
import java.util.Map;

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
@Table(name="cartItems")
public class CartItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartItemsId")
	private Integer cartItemsId;
	
	@Column(name="cartItemsAmount")
	private Integer cartItemsAmount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_cart_id")
	private Cart cartId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_product_id")
	private Product pId;
	
	public CartItems() {
	}

	public Integer getCartItemsId() {
		return cartItemsId;
	}

	public void setCartItemsId(Integer cartItemsId) {
		this.cartItemsId = cartItemsId;
	}

	public Integer getCartItemsAmount() {
		return cartItemsAmount;
	}

	public void setCartItemsAmount(Integer cartItemsAmount) {
		this.cartItemsAmount = cartItemsAmount;
	}

	public Cart getCartId() {
		return cartId;
	}

	public void setCartId(Cart cartId) {
		this.cartId = cartId;
	}

	public Product getpId() {
		return pId;
	}

	public void setpId(Product pId) {
		this.pId = pId;
	}

}
