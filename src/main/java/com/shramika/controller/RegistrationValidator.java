package com.yusuf.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.yusuf.pojo.User;

public class RegistrationValidator implements Validator {

	public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }
	
	
	String STRING_PATTERN = "[a-zA-Z]+"; 
	String ID_PATTERN = "[0-9]+";  
    public void validate(Object obj, Errors errors)
    {
        
    	User user = (User) obj;
        String a = user.getFirstname();
    String q=   a.replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","+").trim();
        	 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.invalid.user", "First Name Required");
      user.setFirstname(q);  


       
      String b = user.getLastname();
      String r=   b.replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","+").trim();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.invalid.user", "Last Name Required");
        user.setLastname(r);
        String c = user.getUsername();
        String s=   c.replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","+").trim();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
        user.setUsername(s);
        String d = user.getPassword();
        String t=   d.replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","+").trim();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        user.setPassword(t);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "UserType", "error.invalid.user", "UserType Required");
        
        
        
        if (!(user.getFirstname() != null && user.getFirstname().isEmpty())) {  
        	Pattern   pattern = Pattern.compile(STRING_PATTERN);  
        	Matcher  matcher = pattern.matcher(user.getFirstname());  
        	   if (!matcher.matches()) {  
        	    errors.rejectValue("firstname", "name.containNonChar",  
        	      "Enter a valid name");  
        	   }  
        	  } 
        
        if (!(user.getLastname() != null && user.getLastname().isEmpty())) {  
        	Pattern   pattern = Pattern.compile(STRING_PATTERN);  
        	Matcher  matcher = pattern.matcher(user.getLastname());  
        	   if (!matcher.matches()) {  
        	    errors.rejectValue("lastname", "name.containNonChar",  
        	      "Enter a valid name");  
        	   }  
        	  } 
        
    }
}
