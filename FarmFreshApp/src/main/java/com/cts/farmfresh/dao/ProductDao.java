package com.cts.farmfresh.dao;

import java.sql.ResultSet;  

import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.cts.farmfresh.model.Product;  
@Repository  
public class ProductDao 
{  
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

public int save(Product p)
{  
    String sql="insert into Product(productId,category,productName,productPrice,quantity) values("+p.getProductId()+",'"+p.getCategory()+"','"+p.getProductName()+"',"+p.getProductPrice()+","+p.getQuantity()+")";  
    return template.update(sql);  
}  
public int update(Product p)
{  
    String sql="update Product set category='"+p.getCategory()+"', productName='"+p.getProductName()+"',productPrice="+p.getProductPrice()+",quantity="+p.getQuantity()+" where productId="+p.getProductId()+"";  
    return template.update(sql);  
}  
public int delete(int id)
{  
    String sql="delete from Product where productid="+id+"";  
    return template.update(sql);  
}  
public Product getProductById(int id)
{  
    String sql="select * from Product where productId=?";  
    return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Product>(Product.class));  
}  
    
public List<Product> getProducts()
{  
    return template.query("select * from Product", new RowMapper<Product>()
    {  
        public Product mapRow(ResultSet rs, int row) throws SQLException 
        {  
            Product e=new Product();  
            e.setProductId(rs.getInt(1));  
            e.setCategory(rs.getString(2));  
            e.setProductName(rs.getString(3));  
            e.setProductPrice(rs.getDouble(4));
            e.setQuantity(rs.getInt(5));
            
            return e;  
        }  
    });  
}  
}
