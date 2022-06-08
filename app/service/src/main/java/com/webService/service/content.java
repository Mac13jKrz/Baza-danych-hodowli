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
import java.sql.Date;
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
	public RedirectView index(HttpServletRequest request){

		request.getSession().setAttribute("user", "null");
		return new RedirectView("index.html");
	}

	@GetMapping("/main")
	@ResponseBody
	public ModelAndView mojekruwy(HttpServletRequest request){
		if("null".equals(request.getSession().getAttribute("user")) || request.getSession().getAttribute("user")==null)
			return new ModelAndView("forward: ./index.html");
		request.getSession().setAttribute("kruwy", hodowle.findAll());
		return new ModelAndView("krowy");
	}
	@GetMapping("/register")
	@ResponseBody
	public ModelAndView main(HttpServletRequest request){
	if("null".equals(request.getSession().getAttribute("user")) || request.getSession().getAttribute("user")==null)
		return new ModelAndView("main");
		return mojekruwy(request);
	}
	@RequestMapping("/login")
    @ResponseBody
    public RedirectView logon(@RequestParam("password") String haslo,@RequestParam("username") String login,HttpServletRequest request) {
    	String password;
    		uzytkownik=uzyt.findByLogin(login);
    		password=uzytkownik.getHaslo();
    		System.out.println(login+" "+uzytkownik.getHaslo());
    		if(password.equals(haslo)) {
    			LogError = false;
    			request.getSession().setAttribute("user", login);
    			return new RedirectView("/main");
    			
    		}
    		else {
    			LogError = true;
    			request.getSession().setAttribute("user", "null");
    			return new RedirectView("/");
    			
    		}

    }
	@GetMapping("/logout")
	public RedirectView logout(HttpServletRequest request) {
		request.getSession().setAttribute("user", "null");
		return new RedirectView("./");
	}
	@RequestMapping("/dodajKrowe")
    @ResponseBody
    public RedirectView dodajK(@RequestParam("numer_ID") String numer_ID,
    		@RequestParam("data_paszportu") Date data_paszportu,
    		@RequestParam("kolczyk_ID") int kolczyk_ID,
    		@RequestParam("data_urodzenia") Date data_urodzenia,
    		@RequestParam("plec") String plec,
    		@RequestParam("rasa") String rasa,
    		@RequestParam("numer_ID_matki") String numer_ID_matki,
    		@RequestParam("kolczyk_ID_matki") int kolczyk_ID_matki) {
	    	this.hodowle.insertHodowla(numer_ID, data_paszportu, kolczyk_ID, data_urodzenia, plec, rasa, numer_ID_matki, kolczyk_ID_matki);
		return new RedirectView("/main");
    }
	@RequestMapping("/usunKrowe/{numer_ID}")
    @ResponseBody
    public RedirectView usunK(@PathVariable("numer_ID") String numer_ID) {
	    	this.hodowle.deleteHodowla(numer_ID);
		return new RedirectView("/main");
    }
	@RequestMapping("/register/confirm")
    @ResponseBody
    public RedirectView registration(@RequestParam("login") String login,@RequestParam("haslo1") 
    String password,@RequestParam("haslo2") String password2) {
		if(this.uzyt.findByLogin(login)==null)
    		if(password.equals(password2)) {
    			uzyt.insertUser(login, password);
    			return new RedirectView("/main");
    		}
		return new RedirectView("/register");

    }
    @ModelAttribute 
    public void setError(Model model) {
    	model.addAttribute("loginerror",LogError);
    	model.addAttribute("user","null");
    }
}
