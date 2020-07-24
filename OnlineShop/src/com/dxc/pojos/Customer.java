package com.dxc.pojos;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Customer 
{
	
	@Id
	private int customer_id;
	private String customer_name;
	private String customer_password;
	private double wallet;
	

	
	public Customer() {

	}

	public Customer(int customer_id, String customer_name, String customer_password, double wallet) {
		super();		
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_password = customer_password;
		this.wallet = wallet;
	}



	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
	

}
