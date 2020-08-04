package com.cts.farmfresh.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.farmfresh.dao.OrderDao;
import com.cts.farmfresh.dao.ProductDao;
import com.cts.farmfresh.model.OrderDetailsUpdateDb;
import com.cts.farmfresh.model.OrderUpdateDb;
import com.cts.farmfresh.model.Orders;
import com.cts.farmfresh.model.Product;

@Controller
public class CartController {
	@Autowired
	ProductDao dao;
	
	@Autowired
	OrderDao dao1;

	@RequestMapping("/addtocart")	
	 public String viewcust(Model m)
    {  
        List<Product> list=dao.getProducts();  
        m.addAttribute("list",list);
        return "addtocart";  
    }
	@RequestMapping("/viewcart")
	public String viewcart()
	{
		return "viewcart";
	}
	@RequestMapping("/sorrypage")
	public String sorrycart()
	{
		return "sorrypage";
	}
	/*@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String buy(@RequestParam int prodid, Model m, HttpSession session) {
		//Product prod=dao.getProductById(prodid);
		if (session.getAttribute("cart") == null) {
			List<Orders> cart = new ArrayList<Orders>();
			cart.add(new Orders(dao.getProductById(prodid), 1));
			session.setAttribute("cart", cart);
		} else {
			List<Orders> cart = (List<Orders>) session.getAttribute("cart");
			int index = this.exists(prodid, cart);
			if (index == -1) {
				cart.add(new Orders(dao.getProductById(prodid), 1));
			} else {
				int quantityp = cart.get(index).getQuantitypurchase() + 1;
				cart.get(index).setQuantitypurchase(quantityp);
			}
			session.setAttribute("cart", cart);
		}
		return "viewcart";
	}*/
	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String buy(@RequestParam int prodid, Model m, HttpSession session) {
		//Product prod=dao.getProductById(prodid);
		if (session.getAttribute("cart") == null) {
			List<Orders> cart = new ArrayList<Orders>();
			cart.add(new Orders(dao.getProductById(prodid), 1));
			session.setAttribute("cart", cart);
		} else {
			List<Orders> cart = (List<Orders>) session.getAttribute("cart");
			int index = this.exists(prodid, cart);
			if (index == -1) {
				cart.add(new Orders(dao.getProductById(prodid), 1));
			} else {
				int quantityp = cart.get(index).getQuantitypurchase() + 1;
				  if (quantityp>5) {
					  return "sorrypage";
				  }
				cart.get(index).setQuantitypurchase(quantityp);
			}
			session.setAttribute("cart", cart);
		}
		return "viewcart";
	}


	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@RequestParam int prodid, Model m, HttpSession session) {
		//Product p = new Product();
		List<Orders> cart = (List<Orders>) session.getAttribute("cart");
		int index = this.exists(prodid, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "viewcart";
	}

	private int exists(int prodid, List<Orders> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getP().getProductId()==prodid) {
				return i;
			}
		}
		return -1;
	}
	
	@RequestMapping(value = "/confirmorder", method = RequestMethod.GET)
	public String confirmOrder(@RequestParam double sum, Model m, HttpSession session) {
		
		List<Orders> cart = (List<Orders>) session.getAttribute("cart");
		
		OrderUpdateDb ord = new OrderUpdateDb();
		ord.setUserid((int) session.getAttribute("user"));
		ord.setProgress("Confirm");
		ord.setAmount(sum);
		dao1.orderSave(ord);
		
		for(int i=0;i<cart.size();i++) {
			Orders o = cart.get(i);
			OrderDetailsUpdateDb odp = new OrderDetailsUpdateDb();
			odp.setOrderid(dao1.querydb(session));
			odp.setProductid(o.getP().getProductId());
			odp.setProductname(o.getP().getProductName());
			odp.setQuantity(o.getQuantitypurchase());
			dao1.orderDetailsSave(odp);
		}


		return "success";
		
	}

}