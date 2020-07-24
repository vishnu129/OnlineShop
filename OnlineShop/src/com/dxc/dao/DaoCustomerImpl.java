package com.dxc.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class DaoCustomerImpl implements IDaoCustomer 
{
	
	private static SessionFactory sessionfact;
	
	static {
	Configuration config= new Configuration().configure(); 
	sessionfact=config.buildSessionFactory();
	}
	
	

	@Override
	public boolean customerLogin(int id, String password) 
	{
		Session session = sessionfact.openSession();
		Query q= session.createQuery("from Customer");
		List<Customer> list= q.getResultList();
		for(Customer c:list)
		{
			if(c.getCustomer_id()==id && c.getCustomer_password().equals(password))
			{
				return true;
			}

		}
		return false;
	}

	@Override
	public int addToCart(int productid,int quantity,int customerid) 
	{
		try
		{
		Session session = sessionfact.openSession();
		Query q= session.createQuery("from Product where product_id=:id");
		q.setParameter("id", productid);
		List<Product> list= q.getResultList();
		if(list.isEmpty())
		{
			session.close();
			return 1;
		}
		else
		{
			Query q1= session.createQuery("from Product where product_id=:id");
			q1.setParameter("id", productid);
			List<Product> list1= q1.getResultList();
			Product p= list1.get(0);
			int qn=p.getQuantity();
			
			if(quantity > qn)
			{
				session.close();
				return 2;
			}
			else
			{
				Cart c = new Cart();
				Query q2= session.createQuery("from Cart");
				List<Cart> cartlist = q2.getResultList();
				Collections.sort(cartlist);
				//System.out.println(cartlist);
				if(cartlist.isEmpty())
				{
			
					  c.setCart_id(1); 
					  c.setCustomer_id(customerid);
					  c.setProduct_id(productid);
					  c.setQuantity(quantity);
					  session.beginTransaction();
					  session.save(c);
					  session.getTransaction().commit();
					  
					  session.close();
					  return 0;
					 
				}
				else 
				{
					for(Cart cart:cartlist)
					{
						System.out.println("not empty");
						System.out.println(cart.getProduct_id() +" and " +productid);
					  if(cart.getProduct_id()==productid && cart.getCustomer_id()==customerid)
					  {
						  session.close();
						  return 3;  
					  }
					}
					  
					  
						System.out.println("not present");
						Cart c1=new Cart();
						Cart c2=new Cart();
						int size =cartlist.size();
						c2=cartlist.get(size-1);
						int cid=c2.getCart_id();
						cid++;
						c1.setCart_id(cid);
						c1.setCustomer_id(customerid);
						c1.setProduct_id(productid);
						c1.setQuantity(quantity);
						session.beginTransaction();
						session.save(c1);
						session.getTransaction().commit();	
					  
					}
					session.close();
				return 0;
				
					}
				
			}
				
		}
		catch (Exception e)
		{
			
			return 0;
		}
	}

	@Override
	public List<Product> showProducts()
	{
		Session session = sessionfact.openSession();
		Query q= session.createQuery("from Product");
		List<Product> list= q.getResultList();
		session.close();
		Collections.sort(list);
		return list;
	}

	
	@Override
	public List<Product> showCart(int customerid) 
	{
		try
		{
		Session session = sessionfact.openSession();
		Query q= session.createQuery("from Cart where customer_id=:cid");
		q.setParameter("cid", customerid);
		List<Cart> clist= q.getResultList();
		if(clist.isEmpty())
		{
			return null;
		}
		Collections.sort(clist);
		List<Product> pl = new ArrayList<>();
		for(Cart c:clist)
		{
			int id = c.getProduct_id();
			Query q1= session.createQuery("from Product where product_id=:pid");
			q1.setParameter("pid", id);
			List<Product> plist=q1.getResultList();
			plist.get(0).setQuantity(c.getQuantity());
			pl.add(plist.get(0));
		}
		session.close();
		return pl;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Product> checkOut(int customerid)
	{
		Session session = sessionfact.openSession();
		Query q= session.createQuery("from Cart where customer_id=:cid");
		q.setParameter("cid", customerid);
		List<Cart> clist= q.getResultList();
		Collections.sort(clist);
		List<Product> pl = new ArrayList<>();
		for(Cart c:clist)
		{
			int id = c.getProduct_id();
			Query q1= session.createQuery("from Product where product_id=:pid");
			q1.setParameter("pid", id);
			List<Product> plist=q1.getResultList();
			if(plist.get(0).getQuantity()<c.getQuantity())
			{
				session.close();
				return null;
			}
			plist.get(0).setQuantity(c.getQuantity());
			pl.add(plist.get(0));
		}
		session.close();
		return pl;
	}

	@Override
	public double addBalance(double amt,int customerid)
	{
		Session session = sessionfact.openSession();
		Query q= session.createQuery("from Customer where customer_id=:cid");
		q.setParameter("cid", customerid);
		List<Customer> list = q.getResultList();
		double namt = list.get(0).getWallet();
		namt = namt+amt;
		
		session.beginTransaction();
		Query q4=session.createQuery("update Customer set wallet=:namt where customer_id=:cid");
		q4.setParameter("namt",namt);
		q4.setParameter("cid",customerid);
		q4.executeUpdate();
		session.getTransaction().commit();
		
		
		session.close();
		return 0;
	}

	@Override
	public double payBill(int customerid, double amt)
	{
		double amount =amt;
		double namt=0;
		Session session = sessionfact.openSession();
		Query q5= session.createQuery("from Customer where customer_id=:cid");
		q5.setParameter("cid", customerid);
		List<Customer> culist=q5.getResultList();
		namt=culist.get(0).getWallet();
		System.out.println(namt);
		System.out.println(amt);
		if(amt>namt)
		{
			session.close();
			return 2;
		}
		
		namt=namt-amt;
		//wallet of customer is updated
		session.beginTransaction();
		Query q4=session.createQuery("update Customer set wallet=:namt where customer_id=:cid");
		q4.setParameter("namt",namt);
		q4.setParameter("cid",customerid);
		q4.executeUpdate();
		session.getTransaction().commit();
		
		
		
		Query q= session.createQuery("from Cart where customer_id=:cid");
		q.setParameter("cid", customerid);
		List<Cart> clist= q.getResultList();
		Collections.sort(clist);
		List<Product> pl = new ArrayList<>();
		for(Cart c:clist)
		{
			int id = c.getProduct_id();
			int qn= c.getQuantity();
			int qn1 = 0;
			
			Query q2= session.createQuery("from Product where product_id=:pid");
			q2.setParameter("pid", id);
			List<Product> prodlist=q2.getResultList();
			qn1 = prodlist.get(0).getQuantity();
			qn1 = qn1-qn;

			//update product table with new quantity
			session.beginTransaction();
			Query q1=session.createQuery("update Product set quantity=:qn where product_id=:product_id");
			q1.setParameter("qn",qn1);
			q1.setParameter("product_id",id);
			q1.executeUpdate();
			session.getTransaction().commit();
			

		}
		//empty cart
		session.beginTransaction();
		Query q3=session.createQuery("delete from Cart where customer_id=:i");
		q3.setParameter("i",customerid);
		q3.executeUpdate();
		session.getTransaction().commit();	
		
		session.close();
		return 0;
	
	}

	@Override
	public double deleteCart(int customerid, int productid)
	{

		Session session = sessionfact.openSession();
		session.beginTransaction();
		Query q3=session.createQuery("delete from Cart where customer_id=:i and product_id=:p");
		System.out.println("this is running");
		q3.setParameter("i",customerid);
		q3.setParameter("p",productid);
		double s = q3.executeUpdate();
		session.getTransaction().commit();	
		
		session.close();
		return s;
		
	}

	@Override
	public double showBalance(int customerid) 
	{
		Session session = sessionfact.openSession();
		Query q= session.createQuery("from Customer where customer_id=:cid");
		q.setParameter("cid", customerid);
		List<Customer> list = q.getResultList();
		double namt = list.get(0).getWallet();
		
		session.close();
		return namt;
	
	}

	@Override
	public boolean changePassword(int id, String password) 
	{
		Session session = sessionfact.openSession();
		session.beginTransaction();
		Query q1=session.createQuery("update Customer set customer_password=:pass where customer_id=:cid");
		q1.setParameter("pass",password);
		q1.setParameter("cid",id);
		q1.executeUpdate();
		session.getTransaction().commit();
		
		session.close();
		return false;
	}

}
