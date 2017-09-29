package com.yusuf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yusuf.dao.CartDAO;
import com.yusuf.pojo.CartItem;
import com.yusuf.pojo.User;
import com.yusuf.spring.exception.AdException;
@Controller
public class DeleteFromCartController {


	
	@RequestMapping(value = "/deleteFromCart.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("cartitem") CartItem cartitem, BindingResult result,HttpServletRequest htp) throws Exception {
		
		if (result.hasErrors()) {
			return "CustProd";
		}

		try {
			System.out.print("test");
			CartDAO userDao = new CartDAO();
			System.out.print("test1");
			
			HttpSession session = htp.getSession();
			System.out.println("from page: "+htp.getParameter("prodID"));
			
			long cartId=Long.parseLong(htp.getParameter("cartId"));
			
			System.out.println(""+cartId);
			User uid= (User)session.getAttribute("user");
			long id=uid.getUserId();
		
			
		userDao.delete(cartId);
		
		
		
		
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

	return "ToCustomerCart";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/deleteFromCart.htm",method = RequestMethod.GET)
public ModelAndView initializeForm(@RequestParam("cartId")long cartId,@ModelAttribute("cartitem") CartItem cartitem, BindingResult result)throws Exception {
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("cartId",cartId);
		mv.setViewName("DeleteItem");
		return mv;
	}
	
}
