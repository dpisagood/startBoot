package cn.iamdp.startBoot.jpa.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.iamdp.startBoot.jpa.dao.JpaUserDao;
import cn.iamdp.startBoot.jpa.entity.User;
import cn.iamdp.startBoot.jpa.server.JpaUserServerInter;

@Service
public class JpaUserServerImpl implements  JpaUserServerInter {

	
  	@Resource
    private JpaUserDao jpaUserDao;
	
	
	@Override
	@Cacheable(value="userList", keyGenerator="mykeyGenerator")
	public List<User> getUserList() {
		System.out.println("+++++++++++++++++++调用数据库+++++++++++++++++");
		return jpaUserDao.findAll();
	}

	@Override
	public User findUserById(String id) {
		
		return jpaUserDao.findOne(id);
	}

	@Override
//	@CachePut(value="userList")
	@CacheEvict(value="userList",allEntries=true)
	public void save(User user) {
		jpaUserDao.save(user);
	}

	@Override
//	@CachePut(value="userList",keyGenerator="mykeyGenerator")
	@CacheEvict(value="userList",allEntries=true)
	public void edit(User user) {
		System.out.println("++++++++++++++++++修改保存+++++++++++++++++++++");
		jpaUserDao.save(user);
	}


	@Override
	@CachePut(value="userList")
	public void delete(String id) {
		jpaUserDao.delete(id);		
	}
	
}
