package cn.iamdp.startBoot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.iamdp.startBoot.jpa.entity.User;

public interface JpaUserDao extends JpaRepository<User, String>{
	User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}
