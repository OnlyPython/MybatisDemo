package com.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.inter.IUserOperation;
import com.mybatis.model.Article;

@Controller
@RequestMapping("/article")
public class UserController {
//	这里一般都是注入Service的，注入mapper应该是为了方便吧
	@Autowired
	IUserOperation userMapper;
	
	
	@RequestMapping("/list")
	public ModelAndView listall(int id){
		id = 1;
		List<Article> userArticlers = userMapper.getUserArticlers(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("articles", userArticlers);
		return modelAndView;
		
	}

}
