package com.dxc.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart implements Comparable<Cart>
{
	@Id
	private int cart_id;
	private int customer_id;
	private int product_id;
	private int quantity;
	
	public Cart() 
	{
	}

	public Cart(int cart_id, int customer_id, int product_id, int quantity) {
		super();
		this.cart_id = cart_id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", customer_id=" + customer_id + ", product_id=" + product_id
				+ ", quantity=" + quantity + "]";
	}

	

	@Override
	public int compareTo(Cart arg0) 
	{
		
		 if(this.cart_id < arg0.cart_id) 
			  return -1;
		  else if(this.cart_id > arg0.cart_id) 
			  return 1; 
		  else
			  return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cart_id;
		result = prime * result + customer_id;
		result = prime * result + product_id;
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cart_id != other.cart_id)
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (product_id != other.product_id)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	

	
	
	
	
}
