package com.webService.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.webService.service.userInterfaceSection.login;
import com.webService.service.userSection.*;
import com.webService.service.shopSection.*;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

@org.springframework.stereotype.Controller
public class content {
	
	private user ActiveUser = new user();
	
	private shopentity CurrentProduct = new shopentity();
	private shopentitycontent CurrentProductContent = new shopentitycontent();
	private shopentityinfo CurrentProductInfo = new shopentityinfo();
	
	
	@Autowired
	private userrepository Users;
	@Autowired
	private shopentityrepository Products;
	@Autowired
	private shopentitycontentrepository ProductsContent;
	@Autowired
	private shopentityinforepository ProductsInfo;
	@Autowired
	private login loginInterface;
	@RequestMapping("/main")
	public ModelAndView firstPage() {
		return new ModelAndView("main");
	}

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("login") String loginP, @RequestParam("password") String passwordP) {
    	if(loginInterface.logIn(loginP,passwordP,Users,ActiveUser))
    		return "Zalogowano Pomyślnie!";
    	return loginP+" "+passwordP;
    }

    @GetMapping("/hello2")
    @ResponseBody
    public String hello2(@RequestParam(name="name", required = false) String name) {
        return "Hello " + name;
    }

    
    /*@GetMapping("/product/view/{id}")
    @ResponseBody
    public ModelAndView productViewMethod(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
    	CurrentProduct = Products.getById(id);
    	System.out.println(CurrentProduct.getName());
    	CurrentProductContent = ProductsContent.getById(id);
    	//CurrentProductInfo = ProductsInfo.getById(id);
    	redirectAttributes.addFlashAttribute("currentproduct", CurrentProduct);
    	redirectAttributes.addFlashAttribute("currentproductcontent", CurrentProductContent);
        return new ModelAndView("product");
    }*/
    @GetMapping(path="/all")
    public @ResponseBody List<user> getAllProducts() {
    	return Users.getAllUsers();
    }
}