package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Product;

public interface IDaoCustomer
{
	public boolean customerLogin(int id,String password);
	public int addToCart(int productid,int quantity,int customerid);
	public List<Product> showProducts();
	public List<Product> showCart(int customerid);
	public List<Product> checkOut(int customerid);
	public double addBalance(double amt,int customerid);
	public double payBill(int customerid,double amt);
	public double deleteCart(int customerid,int productid);
	public double showBalance(int customerid);
	public boolean changePassword(int id,String password);
}
