package com.webService.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
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
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

@org.springframework.stereotype.Controller
public class content {
	
	@Autowired
	private hodowlarepository hodowle;
	private hodowla krowa;
	private boolean LogError = false;
	user uzytkownik;
	private user AUser;
	@Autowired
	userrepository uzyt;
	@GetMapping("/all")
	@ResponseBody
	public List<hodowla> zwrot(){
		return hodowle.findAll();
	}
	@GetMapping("/")
	@ResponseBody
	public ModelAndView index(){
		return new ModelAndView("main");
	}
	@GetMapping("/main")
	@ResponseBody
	public ModelAndView main(){
		return new ModelAndView("main");
	}
    @RequestMapping("/login")
    @ResponseBody
    public RedirectView logon(@RequestParam("password") String haslo,@RequestParam("username") String login) {
    	String password;
    		uzytkownik=uzyt.findByLogin(login);
    		password=uzytkownik.getHaslo();
    		System.out.println(login+" "+uzytkownik.getHaslo());
    		if(password.equals(haslo)) {
    			LogError = false;
    			AUser = uzytkownik;
    			return new RedirectView("/main");
    			
    		}
    		else {
    			LogError = true;

    			return new RedirectView("/");
    			
    		}

    }
    @ModelAttribute 
    public void setError(Model model) {
    	model.addAttribute("loginerror",LogError);
    }
}
