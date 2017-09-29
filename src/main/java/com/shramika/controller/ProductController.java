package com.yusuf.controller;

import java.io.File;

import javax.servlet.ServletContext;
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

import com.yusuf.dao.ProductDAO;
import com.yusuf.pojo.Product;
import com.yusuf.pojo.User;
//import com.yusuf.spring.dao.UserDAO;
import com.yusuf.spring.exception.AdException;
//import com.yusuf.spring.pojo.User;

@Controller
@RequestMapping("/AddProduct.htm")
public class ProductController {
	@Autowired
    ServletContext servletContext;
	@Autowired
	@Qualifier("ProductValidator")
	ProductValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	private static final String SAVE_DIR =  "resources\\";
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("prod") Product prod, BindingResult result,HttpServletRequest htp)throws Exception {
		validator.validate(prod, result);
		if (result.hasErrors()) {
			return "AddProduct";
		}

		try {
			System.out.print("test");
			ProductDAO productDao = new ProductDAO();
			System.out.print("test1");
			
					HttpSession session = htp.getSession();
					User u= (User)session.getAttribute("user");
					long id=u.getUserId();
					Product p1=(Product)session.getAttribute("prod");
					
					  File file;
                      String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
                      String path = null;
                      String savePath = null;
                      if(check.equalsIgnoreCase("\\")) {
                       path = servletContext.getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
                      savePath = path+ File.separator+SAVE_DIR;
                      
                      }
                      
                   
                       if(check.equalsIgnoreCase("/")) {
                      path = servletContext.getRealPath("").replace("build/","");
                      path += "/"; //Adding trailing slash for Mac systems.

                   }
                      
                       if(prod.getPhoto()!=null){
                       String fileNameWithExt=System.currentTimeMillis()+prod.getPhoto().getOriginalFilename();
                       file=new File(savePath+fileNameWithExt);
                       String context=servletContext.getContextPath();
                       prod.getPhoto().transferTo(file);
                       prod.setPhotoName(fileNameWithExt);
                       productDao.create(prod.getProdDescription(),prod.getProdname(),prod.getProdprice(),id,prod.getPhotoName(),prod.getSellerquant());
                       }    
                   
            
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "AddedProduct";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("prod") Product prod, BindingResult result) {

		return "AddProduct";
	}
}
