package com.cts.farmfresh.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.farmfresh.model.User;  
@Repository  
public class UserDao 
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

public int save(User p)
{  
    String sql="insert into User(fname,lname,email,pword,mobNo,address) values('"+p.getFname()+"','"+p.getLname()+"','"+p.getEmail()+"','"+p.getPword()+"','"+p.getMobNo()+"','"+p.getAddress()+"')";  
    return template.update(sql);  
}  
public int update(User p)
{  
    String sql="update User set fname='"+p.getFname()+"', lname='"+p.getLname()+"',email='"+p.getEmail()+"',pword='"+p.getPword()+"',mobNo='"+p.getMobNo()+"',address='"+p.getAddress()+"' where id="+p.getUserId()+"";  
    return template.update(sql);  
}  
public int delete(int id)
{  
    String sql="delete from Employee where id="+id+"";  
    return template.update(sql);  
}  
public User getUserById(int id)
{  
    String sql="select * from Employee where userId=?";  
    return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));  
}  

public int findByUserPassword(String email , String pword) {

	String sql = "SELECT userId FROM USER WHERE EMAIL=? AND PWORD=?";
	
	try {

		int userId = template.queryForObject(sql, new Object[] {
				email, pword }, Integer.class);

		System.out.println("user id" + userId);
		return userId;
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		return 0;
	}
}

public String findByFarmerPassword(String email , String pword) {

	String sql = "SELECT EMAIL FROM USERFARM WHERE EMAIL=? AND PWORD=?";
	
	try {

		String userId = template.queryForObject(sql, new Object[] {
				email, pword }, String.class);

		System.out.println("user id" + userId);
		return userId;
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		return null;
	}
}
	
	
	
	



public List<User> getUsers()
{  
    return template.query("select * from User", new RowMapper<User>()
    {  
        public User mapRow(ResultSet rs, int row) throws SQLException 
        {  
            User e=new User();
            e.setUserId(rs.getInt(1));
            e.setFname(rs.getString(2));  
            e.setLname(rs.getString(3));  
            e.setEmail(rs.getString(4));  
            e.setPword(rs.getString(5));
            e.setMobNo(rs.getString(6));
            e.setAddress(rs.getString(7));
            
            
            return e;  
        }  
    });  
}  
}
