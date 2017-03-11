package com.stealth.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stealth.model.GModel;

@RestController
public class GreetController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public GreetController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(path="/greet")
	public List<GModel> greet(){
		return redisTemplate.boundHashOps("App")
					 .entries()
					 .values()
					 .stream()
					 .map(e->(GModel)e)
					 .collect(Collectors.toList());
					 
//		gSubModel.setSubId(1234559);
//		gSubModel.setSubName("DefaultGsubName");
//		gModel.setId(234686);
//		gModel.setName("DefaultGName");
//		return gModel;
	}
	@RequestMapping(path="/addgreet",method=RequestMethod.POST)
	public void addgreet(@ModelAttribute("gModel")GModel gModel){
		redisTemplate.boundHashOps("App")
					 .put("Gmodel3", gModel);
	}
}
