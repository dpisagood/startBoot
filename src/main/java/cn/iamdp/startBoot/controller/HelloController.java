package cn.iamdp.startBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iamdp.startBoot.jpa.dao.JpaUserDao;
import cn.iamdp.startBoot.jpa.entity.User;

@Controller
public class HelloController {

	@Autowired
	private JpaUserDao jpaUserDao;
	
	@GetMapping(path="/hello")
	@ResponseBody
	public String hello() {
		return "hello world !";
	}
	
	@GetMapping(path="/")
	public String index(Model model) {
		List<User> userList=jpaUserDao.findAll();
		model.addAttribute("userList",userList);
		return "index";
	}
}
