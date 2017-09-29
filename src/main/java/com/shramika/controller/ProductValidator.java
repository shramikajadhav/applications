package com.yusuf.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.yusuf.pojo.Product;
import com.yusuf.pojo.User;

public class ProductValidator implements Validator {
	public boolean supports(Class aClass)
    {
        return aClass.equals(Product.class);
    }
	private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
	String STRING_PATTERN = "[a-zA-Z]+"; 
	String ID_PATTERN = "[0-9]+";  
    public void validate(Object obj, Errors errors)
    {
        
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prodprice", "error.invalid.p", "Product Price Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prodname", "error.invalid.p", "Product Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prodDescription", "error.invalid.p", "Product Description Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sellerquant", "error.invalid.p", "SellerQuantity Required");
       
       Pattern pattern = Pattern.compile(IMAGE_PATTERN);
        Matcher matcher;
        MultipartFile photo;
        Product p = (Product) obj;
        
        photo = p.getPhoto();
        //matcher = pattern.matcher(photo.getOriginalFilename());
        
        String b = p.getProdname();
        String r=   b.replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","+").trim();
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prodname", "error.invalid.p", "Product Name Required");
       p.setProdname(r); 
        String a = p.getProdDescription();
        String q=   a.replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","+").trim();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prodDescription", "error.invalid.p", "Product Description Required");
        p.setProdDescription(q);  
        
        
        if(0 == photo.getSize()) {
           errors.rejectValue("photo","error.invalid.p","File is empty");
        }
//              if(!matcher.matches()) {
//             errors.rejectValue("photo","error.invalid.p","Invalid Image Format");
//        }
//        
        if(5000000 < photo.getSize()) {
             errors.rejectValue("photo","error.invalid.p","File size is over 5mb !");
        }
       
       
        if (!(p.getProdname() != null && p.getProdname().isEmpty())) {  
        	   pattern = Pattern.compile(STRING_PATTERN);  
        	   matcher = pattern.matcher(p.getProdname());  
        	   if (!matcher.matches()) {  
        	    errors.rejectValue("prodname", "name.containNonChar",  
        	      "Enter a valid name");  
        	   }  
        	  }  
       
        
        if (p.getProdprice() != null) {  
        	   pattern = Pattern.compile(ID_PATTERN);  
        	   matcher = pattern.matcher(p.getProdprice().toString());  
        	   if (!matcher.matches()) {  
        	    errors.rejectValue("prodprice", "prodprice.incorrect",  
        	      "Enter a numeric value");  
        	   }  
        
    }
        
        
    }
    }







    	
      