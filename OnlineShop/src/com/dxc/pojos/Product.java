package com.dxc.pojos;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product implements Comparable<Product>
{
	
	@Id
	private int product_id;
	private String product_name;
	private double product_cost;
	private int quantity;
	private double discount;
	
	public Product() 
	{ }
	
	public Product(int product_id, String product_name, double product_cost, int quantity, double discount) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_cost = product_cost;
		this.quantity = quantity;
		this.discount = discount;
	}


	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_cost() {
		return product_cost;
	}

	public void setProduct_cost(double product_cost) {
		this.product_cost = product_cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_cost=" + product_cost
				+ ", quantity=" + quantity + ", discount=" + discount + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(product_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + product_id;
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
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
		Product other = (Product) obj;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (Double.doubleToLongBits(product_cost) != Double.doubleToLongBits(other.product_cost))
			return false;
		if (product_id != other.product_id)
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Product p) 
	{
		if(this.product_id < p.product_id) 
			  return -1;
		  else if(this.product_id > p.product_id) 
			  return 1; 
		  else
			  return 0;
	}
	
	
}
