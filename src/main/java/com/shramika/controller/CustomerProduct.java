package com.yusuf.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yusuf.dao.ProductDAO;
import com.yusuf.pojo.Product;
import com.yusuf.pojo.User;
//import com.yusuf.spring.dao.CategoryDAO;
import com.yusuf.spring.exception.AdException;
//import com.yusuf.spring.pojo.Advert;
//import com.yusuf.spring.pojo.Category;

@Controller

public class CustomerProduct {
	@RequestMapping(value = "/CustProd.htm",method=RequestMethod.GET)
	
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProductDAO product = null;
        List productList = null;
        List userIdList = new ArrayList();

        try {
            product = new ProductDAO();
            productList = product.list();

            Iterator productIterator = productList.iterator();

            while (productIterator.hasNext())
            {
                Product pro = (Product) productIterator.next();
                userIdList.add(pro);

            }
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("CustProd", "prod", userIdList);
        return mv;
    }

	
	@RequestMapping(value = "/DisplayProduct.htm",method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProductDAO product = null;
        List productList = null;
        List userIdList = new ArrayList();
        HttpSession session = request.getSession();

        try {
            product = new ProductDAO();
            User uid= (User)session.getAttribute("user");
			long id=uid.getUserId();
                        productList = product.list2(id);

            Iterator productIterator = productList.iterator();

            while (productIterator.hasNext())
            {
                Product pro = (Product) productIterator.next();
                userIdList.add(pro);

            }
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("DisplayProds", "prod", userIdList);
        return mv;
    }
}
