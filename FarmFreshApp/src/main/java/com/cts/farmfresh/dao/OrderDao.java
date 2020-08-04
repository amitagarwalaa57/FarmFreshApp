package com.cts.farmfresh.dao;

import java.sql.SQLException;  
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.farmfresh.model.OrderDetailsUpdateDb;
import com.cts.farmfresh.model.OrderUpdateDb;
import com.cts.farmfresh.model.Product;

@Repository
public class OrderDao {
	
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) 
	{  
	    this.template = template;  
	}

	public JdbcTemplate getTemplate() 
	{
		return template;
	}
	
	public int orderSave(OrderUpdateDb p)
	{  
	    String sql="insert into Ordr(userid,progress,amount) values("+p.getUserid()+",'"+p.getProgress()+"',"+p.getAmount()+")";  
	    return template.update(sql);  
	}
	
	public int orderDetailsSave(OrderDetailsUpdateDb p)
	{  
	    String sql="insert into orderdetails(orderid,productid,productname,quantity) values("+p.getOrderid()+",'"+p.getProductid()+"','"+p.getProductname()+"',"+p.getQuantity()+")";  
	    return template.update(sql);  
	}
	public int querydb(HttpSession session)
	{
		String sql = "select max(orderid) from ordr";
		int id = template.queryForObject(sql, new Object[] {}, Integer.class);
		session.setAttribute("out", id);
		return id;
	}

}
