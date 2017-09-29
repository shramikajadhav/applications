package com.yusuf.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yusuf.controller.UserValidator;
import com.yusuf.dao.UserDAO;
import com.yusuf.spring.exception.AdException;
import com.yusuf.pojo.User;
@Controller
@RequestMapping("/loginuser.htm")
public class LoginController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doLoginAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest htp) throws Exception {
		validator.validate(user, result);
		User u=null;
		String page="";
		if (result.hasErrors()) {
			return "test";
		}

		try {
			System.out.print("test");
			com.yusuf.dao.UserDAO userDao = new com.yusuf.dao.UserDAO();
			System.out.print("test1");
			
		 u=userDao.validate(user.getUsername(), user.getPassword());
		  
			System.out.println("" +user.getUsername());
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
        if(u!=null){
        	HttpSession session=htp.getSession();
        	session.setAttribute("user", u);
        	if(u.getUserType().equals("Customer"))
        	{
        		page="Customer";
        	}
        	else if(u.getUserType().equals("Admin"))
        	{
        		page= "ValidUser";	
        	}
        	
        
        else{
        	
        	page="ValidArtist";
        }
        }
        	else
        	{
        		page="Login";
        	}
        return page;
	}
	
	@RequestMapping(method = RequestMethod.GET)	
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result)throws Exception {
		
		
		return "Login";
	}
	
//    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
//		
//		
//	return mv;	
//		
//	}

}
