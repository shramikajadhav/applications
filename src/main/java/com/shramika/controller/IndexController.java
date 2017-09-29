package com.yusuf.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yusuf.pojo.User;

@Controller
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView doService() {
//		User user = new User();
//		user.setFirstname("Yusuf");
//		user.setLastname("jadhav");
//		user.setUsername("shramika");
//		user.setPassword("123");
//		user.setUserType("Admin");

		try {
			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
			
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			//session.save(user);
			tx.commit();
			session.close();
		} catch (Exception e) {
			//System.out.println("*** EXCEPTION: " + e.getMessage());
		}
		return new ModelAndView("test", "user", "" + " " + "");
	}
}
