package com.dxc.services;

import java.util.List;

import com.dxc.dao.DaoCustomerImpl;
import com.dxc.dao.IDaoCustomer;
import com.dxc.pojos.Product;

public class CustomerServiceImpl implements ICustomerService
{
	
	IDaoCustomer customer = new DaoCustomerImpl();

	@Override
	public boolean customerLogin(int id, String password) {
		
		return customer.customerLogin(id, password);
	}

	@Override
	public int addToCart(int productid,int quantity,int customerid) 
	{
		return customer.addToCart(productid, quantity,customerid);
	}

	@Override
	public List<Product> showProducts() 
	{
		return customer.showProducts();
	}

	@Override
	public List<Product> showCart(int customerid)
	{
	
		return customer.showCart(customerid);
	}

	@Override
	public List<Product> checkOut(int customerid) 
	{
		return customer.checkOut(customerid);
	}

	@Override
	public double addBalance(double amt,int customerid) 
	{
		return customer.addBalance(amt, customerid);
	}

	@Override
	public double payBill(int customerid, double amt)
	{
		
		return customer.payBill(customerid, amt);
	}

	@Override
	public double deleteCart(int customerid, int productid) 
	{
		return customer.deleteCart(customerid, productid);
	}

	@Override
	public double showBalance(int customerid) 
	{
		return customer.showBalance(customerid);
	}

	@Override
	public boolean changePassword(int id, String password) 
	{
		return customer.changePassword(id, password);
	}

}
