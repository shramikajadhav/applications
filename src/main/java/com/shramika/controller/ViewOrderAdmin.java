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

import com.yusuf.dao.CartDAO;
import com.yusuf.pojo.CartItem;
import com.yusuf.pojo.User;
import com.yusuf.spring.exception.AdException;

@Controller
@RequestMapping("/ViewOrder.htm")
public class ViewOrderAdmin {
	@RequestMapping(method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartDAO cd = null;
        List productList = null;
        List userIdList = new ArrayList();
        HttpSession session = request.getSession();
        try {
            cd = new CartDAO();
            User uid= (User)session.getAttribute("user");
			long id=uid.getUserId();
            productList = cd.list1();

            Iterator productIterator = productList.iterator();

            while (productIterator.hasNext())
            {
                CartItem pro = (CartItem) productIterator.next();
                userIdList.add(pro);

            }
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("ViewOrderCart", "cartitem", userIdList);
        return mv;
    }
}
