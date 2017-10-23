package cn.iamdp.startBoot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iamdp.startBoot.jpa.dao.JpaUserDao;
import cn.iamdp.startBoot.jpa.entity.User;

@RestController
public class JpaUserController {

	@Autowired
	private JpaUserDao userDao;
	
	@PostMapping(path="/jpa/user")
	public String addUser(User user) {
		String nickName=userDao.save(user).getNickName();
		return nickName+"创建成功";
	}
}
