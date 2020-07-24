package com.dxc.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class DaoAdminImpl implements IDaoAdmin
{

	private static SessionFactory sessionfact;
	
	static {
	Configuration config= new Configuration().configure(); 
	sessionfact=config.buildSessionFactory();
	}
	

	
	@Override
	public boolean adminLogin(int id, String password) 
	{
		Session session = sessionfact.openSession();
		Query q= session.createQuery("from Admin");
		List<Admin> list= q.getResultList();
		for(Admin a:list)
		{
			if(a.getAdmin_id()==id && a.getAdmin_password().equals(password))
			{
				return true;
			}

		}
		return false;
	}


	@Override
	public boolean addProduct(Product p) 
	{
		try
		{
		Session session = sessionfact.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		
		session.close();
		return true;
		}
		catch(Exception e)
		{
			
			return false;
		}	
	}

	@Override
	public List<Product> showProducts()
	{
		Session session = sessionfact.openSession();
		Query q1= session.createQuery("from Product");
		List<Product> list= q1.getResultList();
		session.close();
		Collections.sort(list);
		return list;
	}
	
	@Override
	public int deleteProduct(int id)
	{
	
		int i=id;
		Session session = sessionfact.openSession();
		session.beginTransaction();
		Query q=session.createQuery("delete from Product where product_id=:i");
		q.setParameter("i",i);
		int a = q.executeUpdate();
		//System.out.println(a);
		session.getTransaction().commit();
		
		session.close();
		return a;
	
	}


	@Override
	public int updateProduct(Product p) 
	{
		int i=p.getProduct_id();
		double cost=p.getProduct_cost();
		double d=p.getDiscount();
		//System.out.println(i+" "+cost+" "+d+p.getProduct_name());
		Session session = sessionfact.openSession();
		session.beginTransaction();
		Query q=session.createQuery("update Product set product_cost=:product_cost , discount=:discount where product_id=:product_id");
		q.setParameter("product_cost",cost);
		q.setParameter("discount",d);
		q.setParameter("product_id",i);
		int a =q.executeUpdate();
		session.getTransaction().commit();
		
		session.close();
		return a;
	}
	

	@Override
	public boolean addCustomer(Customer c)
	{
		try
		{
		c.setCustomer_password("123");
		Session session = sessionfact.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		
		session.close();
		return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public List<Customer> showCustomers()
	{
		Session session = sessionfact.openSession();
		Query q= session.createQuery("from Customer");
		List<Customer> list= q.getResultList();
		
		session.close();
		return list;
		
	}

	@Override
	public int removeCustomer(int id) 
	{
		int i=id;
		Session session = sessionfact.openSession();
		session.beginTransaction();
		Query q=session.createQuery("delete from Customer where customer_id=:i");
		q.setParameter("i",i);
		int a = q.executeUpdate();
		session.getTransaction().commit();
		
		session.close();
		return a;
	}


	@Override
	public int updateStock(int id, int quantity) 
	{
		Session session = sessionfact.openSession();
		session.beginTransaction();
		Query q=session.createQuery("update Product set quantity=:q where product_id=:id");
		q.setParameter("q",quantity);
		q.setParameter("id",id);
		int a = q.executeUpdate();
		session.getTransaction().commit();
		
		session.close();
		return a;
	}
	
}
