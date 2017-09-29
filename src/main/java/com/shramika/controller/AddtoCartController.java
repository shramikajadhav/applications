


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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yusuf.dao.CartDAO;
//import com.yusuf.pojo.CartItem;
import com.yusuf.pojo.CartItem;
import com.yusuf.pojo.Product;
import com.yusuf.pojo.User;
import com.yusuf.spring.exception.AdException;

@Controller

public class AddtoCartController {


	@Autowired
	@Qualifier("CartItemValidator")
	CartItemValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/addToCart.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("cartitem") CartItem cartitem, BindingResult result,HttpServletRequest htp) throws Exception {
		validator.validate(cartitem, result);
		
		if (result.hasErrors()) {
			return "CartProduct";
		}

		try {
			System.out.print("test");
			CartDAO userDao = new CartDAO();
			System.out.print("test1");
			
			HttpSession session = htp.getSession();
			
			long productid=Long.parseLong(htp.getParameter("prodID"));
			long sellerQuantity=Long.parseLong(htp.getParameter("sellerquant"));
			if(sellerQuantity< cartitem.getQuantity() || cartitem.getQuantity()==0)
			{
				return "Valid";
			}
			System.out.println(""+sellerQuantity);
			User uid= (User)session.getAttribute("user");
			long id=uid.getUserId();
		
			long total1 = cartitem.getTotal();

		CartItem u =userDao.create(cartitem.getQuantity(),productid,id,cartitem.getOrderStatus(),total1,cartitem.getPrice());
		
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

	return "ToCustomerCart";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/addToCart.htm",method = RequestMethod.GET)
public ModelAndView initializeForm(@RequestParam("prodID")long productID,@RequestParam("sellerquant")long sellerQuantity,@ModelAttribute("cartitem") CartItem cartitem, BindingResult result)throws Exception {
		
		System.out.println("product id"+productID);
		System.out.println("product id"+sellerQuantity);
		ModelAndView mv = new ModelAndView();
		mv.addObject("prodID",productID);
	mv.addObject("sellerquant", sellerQuantity);
		mv.setViewName("CartProduct");
		return mv;
	}
}

