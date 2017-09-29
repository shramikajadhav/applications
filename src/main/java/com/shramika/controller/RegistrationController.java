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

import com.yusuf.dao.RegisterDAO;
import com.yusuf.pojo.User;
//import com.yusuf.spring.dao.UserDAO;
import com.yusuf.spring.exception.AdException;
//import com.yusuf.spring.controller.UserValidator;
@Controller
@RequestMapping("/Register.htm")
public class RegistrationController {
	@Autowired
	@Qualifier("RegistrationValidator")
	RegistrationValidator validator;
	

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest htp) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "Register";
		}

		try {
			System.out.print("test");
			RegisterDAO userDao = new RegisterDAO();
			System.out.print("test1");
			
			User us= userDao.get(user.getUsername());
			if(us!=null){
				
				return "Error";
				
			}
			
			
			User u=userDao.create( user.getFirstname(), user.getLastname(),user.getPassword(), user.getUsername(),user.getUserType());
			System.out.println(""+user.getUserType());
			HttpSession session=htp.getSession();
        	session.setAttribute("user", u);
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
if(user.getUserType().equals("Customer"))
{      
		return "Customer";
}
else
{
	return "ValidArtist";
}
	}

	@RequestMapping(method = RequestMethod.GET)	
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result)throws Exception {
		
		
		return "Register";
	}
	
}
