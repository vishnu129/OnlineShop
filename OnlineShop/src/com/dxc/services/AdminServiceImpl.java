package com.dxc.services;

import java.util.List;

import com.dxc.dao.DaoAdminImpl;
import com.dxc.dao.IDaoAdmin;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class AdminServiceImpl implements IAdminService
{

	IDaoAdmin admin = new DaoAdminImpl();
	
	@Override
	public boolean adminLogin(int id, String password)
	{
		return admin.adminLogin(id, password);
	}

	@Override
	public boolean addProduct(Product p)
	{
		
		return admin.addProduct(p);
	}

	@Override
	public List<Product> showProducts() 
	{
	
		return admin.showProducts();
	}

	@Override
	public int deleteProduct(int id)
	{
		return admin.deleteProduct(id);
	}

	@Override
	public int updateProduct(Product p)
	{
		
		return admin.updateProduct(p);
	}
	
	@Override
	public boolean addCustomer(Customer c)
	{
		return admin.addCustomer(c);
	}

	@Override
	public List<Customer> showCustomers()
	{
		return admin.showCustomers();
	}

	@Override
	public int removeCustomer(int id)
	{
		return admin.removeCustomer(id);
	}

	@Override
	public int updateStock(int id, int quantity)
	{
		return admin.updateStock(id, quantity);
	}

	

	

	
}
