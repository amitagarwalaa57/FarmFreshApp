package com.cts.farmfresh.controller;


import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.cts.farmfresh.model.Product;  
import com.cts.farmfresh.dao.ProductDao;  
	
@Controller  
public class ProductController
{  
	    @Autowired
	    ProductDao dao1;//will inject dao from xml file  
	      
	    /*It displays a form to input data, here "command" is a reserved request attribute 
	     *which is used to display object data into form 
	     */  
	    @RequestMapping("/addproduct")  
	    public String showform(Model m)
	    {  
	    	m.addAttribute("command", new Product());
	    	return "addproduct"; 
	    }  
	    
	    /*It saves object into database. The @ModelAttribute puts request data 
	     *  into model object. You need to mention RequestMethod.POST method  
	     *  because default request is GET*/  
	    @RequestMapping(value="/saveprod",method = RequestMethod.POST)  
	    public String save(@ModelAttribute("prod") Product prod)
	    {  
	    	
	    	//@ModelAttribute("prod") Product prod
	       //this what giving error 
	    	// Product prod =null;
	    	//System.out.println("Save Prod");
	    	
	    	dao1.save(prod);  
	        return "redirect:/viewproductfarmer";//will redirect to viewemp request mapping  
	    }  
	    
	    /* It provides list of employees in model object */  
	    @RequestMapping("/viewproductfarmer")  
	    public String viewfarm(Model m)
	    {  
	       System.out.println("View Product farmer");
	    	List<Product> list=dao1.getProducts();  
	        m.addAttribute("list",list);
	        return "viewproductfarmer";  
	    }
	    @RequestMapping("/viewproductcustomer")  
	    public String viewcust(Model m)
	    {  
	        List<Product> list=dao1.getProducts();  
	        m.addAttribute("list",list);
	        return "viewproductcustomer";  
	    }
	    
	    /* It displays object data into form for the given id.  
	     * The @PathVariable puts URL data into variable.*/  
	    @RequestMapping(value="/editproduct",method=RequestMethod.GET)  
	    public String edit(@RequestParam int prodid, Model m)
	    {  
	    	
	    	System.out.println("Product ID" +prodid);
	        Product prod=dao1.getProductById(prodid);  
	        m.addAttribute("command",prod);
	        return "prodeditform";  
	    }  
	    
	    /* It updates model object. */  
	    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public String editsave(@ModelAttribute("prod") Product prod )
	    {  
	    	System.out.println("Edit Save");
	    	//@ModelAttribute("prod")
	    //	Product prod = null ;
	    	System.out.println(prod);
	        dao1.update(prod);  
	        return "redirect:/viewproductfarmer";  
	    }
	    
	    /* It deletes record for the given id in URL and redirects to /viewemp */  
	    @RequestMapping(value="/deleteproduct",method = RequestMethod.GET)  
	    public String delete(@RequestParam int prodid, Model m ){  
	        dao1.delete(prodid);  
	        return "redirect:/viewproductfarmer";  
	    }
}
