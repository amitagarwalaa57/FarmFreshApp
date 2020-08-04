package com.cts.farmfresh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.farmfresh.model.Product;
import com.cts.farmfresh.model.User;
import com.cts.farmfresh.dao.ProductDao;
import com.cts.farmfresh.dao.UserDao;  
	
@Controller  
public class UserController 
{  
	    @Autowired  
	    UserDao dao;//will inject dao from xml file 
	    
	    @Autowired
	    ProductDao dao1;
	      
	    /*It displays a form to input data, here "command" is a reserved request attribute 
	     *which is used to display object data into form 
	     */  
	    @RequestMapping("/signup")  
	    public String showform(Model m)
	    {  
	    	m.addAttribute("command", new User());
	    	return "signup"; 
	    }  
	    @RequestMapping("/farmer")  
	    public String showfarmer()
	    {  
	    	return "farmer";
	    }  
	    @RequestMapping("/firstpage")  
	    public String showhome()
	    {
	    	return "firstpage";
	    }  
	    
	    
	    
	    /*It saves object into database. The @ModelAttribute puts request data 
	     *  into model object. You need to mention RequestMethod.POST method  
	     *  because default request is GET*/  
	    @RequestMapping(value="/save",method = RequestMethod.POST)  
	    public String save(@ModelAttribute("user") User user)
	    {  
	        dao.save(user);  
	        return "userlogin";//will redirect to viewemp request mapping  
	    }  
	    
	    /* It provides list of user in model object */  
	    @RequestMapping("/viewuser")  
	    public String viewemp(Model m)
	    {  
	        List<User> list=dao.getUsers();  
	        m.addAttribute("list",list);
	        return "viewuser";  
	    }
	    
	    
	    
	    
	    @RequestMapping("/userHome")	    
	    public String userHome() {	
	    	return "userlogin";
	    	
	    }
	    
	    
	    @RequestMapping(value="/userLogin", method = RequestMethod.POST )	    
	    public ModelAndView userLogin(@RequestParam String email , @RequestParam String pword , HttpSession session) {
	    	
	    	ModelAndView mv = new ModelAndView();
	    	
	    	System.out.println("email"+ email);
			
			int userid =dao.findByUserPassword(email, pword);
			if (userid != 0) 
			{
				session.setAttribute("user", userid);
				//System.out.println("if");
				 List<Product> list=dao1.getProducts();  
			      
				  mv.setViewName("viewproductcustomer");
				  mv.addObject("list",list);
				
				
			}
			else
			{
				System.out.println("errorMessage");
				
				mv.addObject("errorMessage", "Invalid user id or password...");
				mv.setViewName("userlogin");
				
			}
			
			return mv;
	    }
	    
	    @RequestMapping("/farmerHome")	    
	    public String farmerHome() {	
	    	return "farmerlogin";
	    	
	    }
	    
	    
	    @RequestMapping(value="/farmerLogin", method = RequestMethod.POST )	    
	    public ModelAndView farmerLogin(@RequestParam String email , @RequestParam String pword , HttpSession session) {
	    	
	    	ModelAndView mv = new ModelAndView();
	    	
	    	System.out.println("email"+ email);
			
			String name =dao.findByFarmerPassword(email, pword);
			if (name != null) 
			{
				session.setAttribute("user", name);
				//System.out.println("if");  
				  mv.setViewName("farmer");		
			}
			else
			{
				System.out.println("errorMessage");
				
				mv.addObject("errorMessage", "Invalid user id or password...");
				mv.setViewName("farmerlogin");
				
			}
			
			return mv;
	    }
	    
	    
	    /* It displays object data into form for the given id.  
	     * The @PathVariable puts URL data into variable.*/  
	  /*  @RequestMapping(value="/editemp/{id}")  
	    public String edit(@PathVariable int id, Model m)
	    {  
	        User emp=dao.getUserById(id);  
	        m.addAttribute("command",emp);
	        return "usereditform";  
	    }  
	    
	    /* It updates model object. */  
	  /*  @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public String editsave(@ModelAttribute("user") User user)
	    {  
	        dao.update(user);  
	        return "redirect:/viewuser";  
	    }
	    
	    /* It deletes record for the given id in URL and redirects to /viewemp */  
	  /*  @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
	    public String delete(@PathVariable int id){  
	        dao.delete(id);  
	        return "redirect:/viewuser";  
	    }*/ 
}
