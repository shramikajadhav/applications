package com.yusuf.controller;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.yusuf.pojo.CartItem;
import com.yusuf.pojo.User;
public class CartItemValidator implements Validator {

	 public boolean supports(Class aClass)
	    {
	        return aClass.equals(CartItem.class);
	    }
	 
		String ID_PATTERN = "[0-9]+";  

	    public void validate(Object obj, Errors errors)
	    {
	    	CartItem user = (CartItem) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Quantity", "error.invalid.user", "quantity is mandatory");
	        
	        
	        
	       /* if (user.getQuantity().is) {  
	        	  Pattern pattern = Pattern.compile(ID_PATTERN);  
	        	 Matcher  matcher = pattern.matcher(user.getQuantity().toString());  
	        	   if (!matcher.matches()) {  
	        	    errors.rejectValue("prodprice", "prodprice.incorrect",  
	        	      "Enter a numeric value");  
	        	   }  
	        
	    }*/
	        
	    }

}
