package com.dxc.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Product;
import com.dxc.services.CustomerServiceImpl;
import com.dxc.services.ICustomerService;

@RequestMapping("/views")
@Controller
public class CustomerController {
	
	
	ICustomerService cservice = new CustomerServiceImpl();
	
	@RequestMapping(value="/clogin", method = RequestMethod.POST)
	public String CustomerLogin(@RequestParam int id,@RequestParam String password,Model m,HttpSession session)
	{
		session.setAttribute("customerid", id);
		boolean status=cservice.customerLogin(id, password);
		if(status)
		{
		return "customeroptions";
	    }
		else
		{
			m.addAttribute("message", "Wrong credentials");
			return "message";
		}
		
	}
	
	
	@RequestMapping("/showallprod")
	public String showProducts(Model m)
	{
		List<Product>list= cservice.showProducts();
		m.addAttribute("list", list);
		return "showall";
	}
	

	@RequestMapping("/addtocart")
	public String addtoCart(@RequestParam int id,@RequestParam int quantity ,Model m, HttpSession session)
	{
		int customerid=(Integer)session.getAttribute("customerid");
		int b = cservice.addToCart(id,quantity,customerid);
		if(b==1)
		{ 
		m.addAttribute("message","Product id Not found");
		}
		else if(b==2)
		{
			m.addAttribute("message","Product Not available in That quantity");
		}
		else if(b==3)
		{
			m.addAttribute("message","Product Already added in the cart");
		}
		else
		{
			m.addAttribute("message","Product Added to cart");
		}
		return "message";
	}
	
	@RequestMapping("/showcart")
	public String showCart(Model m,HttpSession session)
	{
		
		int customerid=(Integer)session.getAttribute("customerid");
		List<Product>list= cservice.showCart(customerid);
		m.addAttribute("list", list);
		return "showall";
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model m,HttpSession session)
	{
		int customerid = (Integer)session.getAttribute("customerid");
		List<Product>list = cservice.checkOut(customerid);
		if(list==null)
		{
			m.addAttribute("message","Product Quantity not available. please check product list again");
			return "message";
		}
		m.addAttribute("list", list);
		double price=0,dis=0,total=0,ntotal=0;
		int qnt=0;
		for(Product p:list)
		{
			price=p.getProduct_cost();
			dis = p.getDiscount();
			qnt =p.getQuantity();
			ntotal=ntotal+ (price*qnt);
			price=price-(price*(dis/100));
			total= total+ (price*qnt);
			price=0;
			qnt=0;
		}
		total =Math.round(total);
		session.setAttribute("total", total);
		session.setAttribute("ntotal", ntotal);
		return "bill";
	}
	
	@RequestMapping("/paybill")
	public String payBill(Model m,HttpSession session)
	{
		
		int customerid=(Integer)session.getAttribute("customerid");
		double amt = (Double) session.getAttribute("total");
		double s =cservice.payBill(customerid, amt);
		if(s==0)
		{
		m.addAttribute("message","Thank you for shopping with us!!!");
		}
		else if(s==2)
		{
			m.addAttribute("message","Insufficient Balance in wallet !!!");
		}
		return "message";
	}
	
	@RequestMapping("/deletecart")
	public String deleteCart(@RequestParam int id, Model m,HttpSession session)
	{
		
		int customerid=(Integer)session.getAttribute("customerid");
		double a= cservice.deleteCart(customerid, id);
		if(a==0)
		{
			m.addAttribute("message", "Product not found in cart!!");
		}
		else
		{
		m.addAttribute("message", "Product deleted from cart!!");
		}
		return "message";
	}
	
	@RequestMapping("/addbalance")
	public String addBalance(Model m,HttpSession session,@RequestParam double amt)
	{
		
		int customerid=(Integer)session.getAttribute("customerid");
		cservice.addBalance(amt, customerid);
		m.addAttribute("message", "Amount added to Wallet...");
		return "message";
	}
	
	@RequestMapping("/showbalance")
	public String showBalance(Model m,HttpSession session)
	{
		
		int customerid=(Integer)session.getAttribute("customerid");
		double amt = cservice.showBalance(customerid);
		m.addAttribute("message","Wallet Balance is " + amt +" Rs ");
		return "message";
	}
	
	@RequestMapping("/changepassword")
	public String changePassword(Model m,HttpSession session,@RequestParam String password,@RequestParam String password2)
	{
		if(password.equals(password2))
		{
		int customerid=(Integer)session.getAttribute("customerid");
		cservice.changePassword(customerid, password);
		m.addAttribute("message","Password Changed!!!");
		return "message";
		}
		else
		{
		m.addAttribute("message","Passwords Don't Match!!!!");
		return "message";	
		}
	}
	
	
}
