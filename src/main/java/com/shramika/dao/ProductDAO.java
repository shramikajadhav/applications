package com.yusuf.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yusuf.pojo.Product;
import com.yusuf.pojo.User;
import com.yusuf.spring.exception.AdException;
//import com.yusuf.spring.pojo.Email;

public class ProductDAO extends DAO {
public ProductDAO()

{
	
}
public Product create(String productDescription ,String productname ,String productprice,long userId,String photoName,long sellerQuantity)
        throws AdException {
    try {
        begin();
        System.out.println("inside DAO");
       
        User user = new User(userId);
        
        Product p=new Product(productname,productprice, productDescription,photoName, sellerQuantity);
        
       p.setUser(user);
      
        getSession().save(p);
        
        commit();
        return p;
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        throw new AdException("Exception while creating user: " + e.getMessage());
    }
}
public List list() throws AdException {
    try {
        begin();
        Query q = getSession().createQuery("from Product where sellerquant > 0");
        List list = q.list();
        commit();
        return list;
    } catch (HibernateException e) {
        rollback();
        throw new AdException("Could not list the Product", e);
    }
}

public List list2(long userId) throws AdException {
    try {
        begin();
        Query q = getSession().createQuery("from Product where  userId=:userId");
        q.setLong("userId", userId);
        List list = q.list();
        commit();
        return list;
    } catch (HibernateException e) {
        rollback();
        throw new AdException("Could not list the Product", e);
    }
}

public long validate(long productId , long Quantity)
        throws AdException {
    try {
        begin();
        Query q = getSession().createQuery("select sellerquant from Product where prodId = :prodId ");
        q.setLong("prodId", productId);
        
        long quantity =  (Long) q.uniqueResult();
        commit();
        return quantity;
    } catch (HibernateException e) {
        rollback();
        throw new AdException("Invalid Entry " + productId, e);
    }
}


public void update(long productId , long Quantity)
        throws AdException {
    try {
        begin();
        System.out.println("inside DAO");
       
       //ShoppingCart sc=new ShoppingCart(user);
       // User us=new User(firstname,lastname,password,username , UserType);
        
        Query q = getSession().createQuery("update Product set sellerquant = :Quantity where prodId = :prodId");
		q.setLong("Quantity",  Quantity);
		
		q.setLong("prodId", productId);
		q.executeUpdate();

        commit();

    } catch (HibernateException e) {
        rollback();
        
        throw new AdException("Exception while creating user: " + e.getMessage());
    }
}



}
