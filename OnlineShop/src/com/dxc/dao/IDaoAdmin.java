package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public interface IDaoAdmin 
{
	public boolean adminLogin(int id,String password);
	public boolean addProduct(Product p);
	public int deleteProduct(int id);
	public int updateProduct(Product p);
	public List<Product> showProducts();
	public boolean addCustomer(Customer c);
	public List<Customer> showCustomers();
	public int removeCustomer(int id);
	public int updateStock(int id, int quantity);

}
