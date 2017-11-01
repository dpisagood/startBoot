package cn.iamdp.startBoot.jpa.server;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import cn.iamdp.startBoot.jpa.entity.User;
/**
 * user类服务层接口
 * @author DP
 *
 */
public interface JpaUserServerInter {
	
    public List<User> getUserList();

    public User findUserById(String id);

    public void save(User user);

    public void edit(User user);

    public void delete(String id);
}
