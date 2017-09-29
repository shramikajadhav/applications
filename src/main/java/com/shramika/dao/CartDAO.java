package com.yusuf.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.yusuf.pojo.CartItem;
import com.yusuf.pojo.Product;
import com.yusuf.pojo.User;
import com.yusuf.spring.exception.AdException;

public class CartDAO extends DAO{

	public CartDAO()
	{
		
	}
	  
	 public CartItem create(long Quantity,long productId,long UserId,long orderStatus,long total,long price)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	           Query q = getSession().createQuery("from Product where prodID = :prodID");
				q.setLong("prodID", productId);
				Product product = (Product)q.uniqueResult();
				
				long  sid=product.getUser().getUserId();
				
	            User u = new User(UserId);
	            
	            
	           CartItem ci = new CartItem(Quantity);
	           ci.setOrderStatus(0);
	           ci.setProduct(product);
	           ci.setShoppingcart(UserId);
	           long p= Long.parseLong(product.getProdprice());
	           ci.setPrice(p);
	          ci.setTotal(Quantity*p);
	        
	            getSession().save(ci);
	            
	            commit();
	            return ci;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            throw new AdException("Exception while creating user: " + e.getMessage());
	        }
	    }
	 public CartItem viewOrder(long UserId)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	           
	            Query q = getSession().createQuery("from Product where Shoppingcart = :userId and orderStatus=1");
				q.setLong("UserId", UserId);
				CartItem product = (CartItem)q.uniqueResult();
			
	            getSession().save(product);
	            
	            commit();
	            return product;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            throw new AdException("Exception while creating user: " + e.getMessage());
	        }
	    }
	 public List list1(long UserId) throws AdException {
		    try {
		    	
		    	
		        begin();
		        Query q = getSession().createQuery("from Product where shoppingcart = :UserId and orderStatus=1");
		       
		        q.setLong("UserId", UserId);
		       
		        List list = q.list();
		        
		        commit();
		        return list;
		    } catch (HibernateException e) {
		        rollback();
		        throw new AdException("Could not list the CartItem", e);
		    }
}
	 public void delete(long cartId)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	           //ShoppingCart sc=new ShoppingCart(user);
	           // User us=new User(firstname,lastname,password,username , UserType);
	            Query q = getSession().createQuery("delete CartItem where cartId = :cartId");
				q.setLong("cartId", cartId);
				q.executeUpdate();
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            
	            throw new AdException("Exception while creating user: " + e.getMessage());
	        }
	    }
	 
	 public List list(long UserId) throws AdException {
		    try {
		    	
		    	
		        begin();
		        Query q = getSession().createQuery("from CartItem where Shoppingcart= :UserId and orderStatus=:orderStatus");
		        q.setLong("UserId", UserId);
		        q.setLong("orderStatus", 0);
		        List list = q.list();
		        
		        commit();
		        return list;
		    } catch (HibernateException e) {
		        rollback();
		        throw new AdException("Could not list the CartItem", e);
		    }
}
	 public List list1() throws AdException {
		    try {
		    	
		    	
		        begin();
		        Query q = getSession().createQuery("from CartItem where orderStatus=:orderStatus");
		       // q.setLong("UserId", UserId);
		        q.setLong("orderStatus", 1);
		        List list = q.list();
		        
		        commit();
		        return list;
		    } catch (HibernateException e) {
		        rollback();
		        throw new AdException("Could not list the CartItem", e);
		    }
}
	 public void update(long orderStatus , long cartId)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	        
	            Query q = getSession().createQuery("update CartItem set orderStatus = :orderStatus where cartId = :cartId");
				q.setLong("orderStatus", 1);
				q.setLong("cartId", cartId);
				q.executeUpdate();

	        } catch (HibernateException e) {
	            rollback();
	            
	            throw new AdException("Exception while creating user: " + e.getMessage());
	        }
	    }
	 
}
