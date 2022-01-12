package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Controller
public class UserContoller {
	@Autowired
	UserDao userdao;
	@RequestMapping("index")
	public String user() {
		
		return "index.jsp";
	}
     
	
	  @RequestMapping("addUser")
	  public String addUser(User user) {
		  
		  userdao.save(user);
	  
	  return "index.jsp"; }
	       
	  @RequestMapping("getUser")
	  public ModelAndView getUser(@RequestParam int id) {
		  ModelAndView mav =new ModelAndView("ShowUser.jsp");
	      User user=userdao.findById(id).orElse(null);
	      mav.addObject(user);
	      return mav; }
	  
	  @RequestMapping("deleteUser")
	  public ModelAndView deleteUser(@RequestParam int id) {
		  ModelAndView mav =new ModelAndView("deleteUser.jsp");
	      User user=userdao.findById(id).orElse(null);
	      userdao.deleteById(id);
	      mav.addObject(user);
	      return mav; }
	  
	  @RequestMapping("updateUser")
	  public ModelAndView deleteUser(User user) {
		  ModelAndView mav =new ModelAndView("updated.jsp");
	       user=userdao.findById(user.getId()).orElse(null);
	      userdao.deleteById(user.getId());
	      mav.addObject(user);
	      return mav; }
	  
	  
	       
	 
}
