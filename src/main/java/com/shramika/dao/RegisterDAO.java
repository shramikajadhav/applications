package com.yusuf.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.yusuf.pojo.ShoppingCart;
import com.yusuf.pojo.User;
import com.yusuf.spring.exception.AdException;

public class RegisterDAO extends DAO {
	 public RegisterDAO() {
	    }
	 
	 public User get(String username)
	            throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from User where username = :username");
	            q.setString("username", username);
	            User user = (User) q.uniqueResult();
	            commit();
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + username, e);
	        }
	    }

	    
	    
	    public User validate(String username,String password)
	            throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from User where username = :username and password= :password");
	            q.setString("username", username);
	            q.setString("password", password);
	            User user = (User) q.uniqueResult();
	            commit();
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Invalid User " + username, e);
	        }
	    }

	    
	    
	    
	    public User create(String username, String password, String firstname, String lastname , String UserType)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	           ShoppingCart sc=new ShoppingCart();
	           
	            User us=new User(firstname,lastname,password,username , UserType);
	            us.setSc(sc);
	            sc.setUser(us);
	            us.setFirstname(firstname);
	            us.setLastname(lastname);
	         
	            
	            getSession().save(us);
	            
	            commit();
	            return us;
	        } catch (HibernateException e) {
	            rollback();
	           
	            throw new AdException("Exception while creating user: " + e.getMessage());
	        }
	    }

	    public void delete(User user)
	            throws AdException {
	        try {
	            begin();
	            getSession().delete(user);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete user " + user.getUsername(), e);
	        }
	    }

	    
	    
}
