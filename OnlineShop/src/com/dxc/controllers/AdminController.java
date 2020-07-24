package com.dxc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.services.AdminServiceImpl;
import com.dxc.services.IAdminService;

@RequestMapping("/views")
@Controller
public class AdminController {
	
	IAdminService service = new AdminServiceImpl();
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String AdminLogin(@RequestParam int id,@RequestParam String password,Model m)
	{
		
		boolean status=service.adminLogin(id, password);
		if(status)
		{
		return "adminoptions";
	    }
		else
		{
			m.addAttribute("message", "Wrong credentials");
			return "message";
		}
	}
	
	@RequestMapping("/addproduct")
	public String addProduct(@ModelAttribute Product p, Model m)
	{
		boolean b=service.addProduct(p);
		if(b)
		{
		m.addAttribute("message", "Product Added");
		return "message";
		}
		else
		{
			m.addAttribute("message", "Product Id Already Exists!!!");
			return "message";
		}
	}
	
	@RequestMapping("/showproducts")
	public String showProducts(Model m)
	{
		List<Product>list= service.showProducts();
		m.addAttribute("list", list);
		return "showall";
	}
	
	@RequestMapping("/deleteproduct")
	public String deleteProduct(@RequestParam int id  ,Model m)
	{
		int b = service.deleteProduct(id);
		if(b==1)
		{
		m.addAttribute("message","Product Deleted");
		}
		else
		{
			m.addAttribute("message","Product Not Found");
		}
		return "message";
	}
	
	@RequestMapping("/updateproduct")
	public String updateProduct(@ModelAttribute Product p  ,Model m)
	{
		int b = service.updateProduct(p);
		if(b==1)
		{
		m.addAttribute("message","Product Updated");
		}
		else
		{
			m.addAttribute("message","Product Not Found");
		}
		return "message";
	}
	
	@RequestMapping("/addcustomer")
	public String addCustomer(@ModelAttribute Customer c, Model m)
	{
		boolean b=service.addCustomer(c);
		if(b)
		{
		m.addAttribute("message", "Customer Added");
		return "message";
		}
		else
		{
			m.addAttribute("message", "Customer Id Already exists!!!!");
			return "message";	
		}
	}
	
	@RequestMapping("/showcustomers")
	public String showCustomers(Model m)
	{
		List<Customer>list= service.showCustomers();
		m.addAttribute("list", list);
		return "showcustomers";
	}
	
	
	@RequestMapping("/removecustomer")
	public String removeCustomer(@RequestParam int id  ,Model m)
	{
		int b = service.removeCustomer(id);
		if(b==1)
		{
		m.addAttribute("message","Customer Removed");
		}
		else
		{
			m.addAttribute("message","Customer Not Found");
		}
		return "message";
	}
	
	@RequestMapping("/updatestock")
	public String updateStock(@RequestParam int product_id, @RequestParam int quantity,Model m)
	{
		int b = service.updateStock(product_id, quantity);
		if(b==1)
		{
		m.addAttribute("message","Product Stock Updated");
		}
		else
		{
			m.addAttribute("message","Product Not Found");
		}
		return "message";
	}
	

}
