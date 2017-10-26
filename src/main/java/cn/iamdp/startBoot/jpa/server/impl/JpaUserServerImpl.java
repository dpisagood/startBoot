package cn.iamdp.startBoot.jpa.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.iamdp.startBoot.jpa.dao.JpaUserDao;
import cn.iamdp.startBoot.jpa.entity.User;
import cn.iamdp.startBoot.jpa.server.JpaUserServerInter;

@Service
public class JpaUserServerImpl implements  JpaUserServerInter {

	
  	@Resource
    private JpaUserDao jpaUserDao;
	
	
	@Override
	public List<User> getUserList() {
		return jpaUserDao.findAll();
	}

	@Override
	public User findUserById(String id) {
		
		return jpaUserDao.findOne(id);
	}

	@Override
	public void save(User user) {
		jpaUserDao.save(user);
	}

	@Override
	public void edit(User user) {
		jpaUserDao.save(user);
	}


	@Override
	public void delete(String id) {
		jpaUserDao.delete(id);		
	}
	
}
