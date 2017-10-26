package cn.iamdp.startBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.iamdp.startBoot.jpa.dao.JpaUserDao;
import cn.iamdp.startBoot.jpa.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartBootApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private JpaUserDao jpaUserDao;
	@Test
	public void jpaUserTest() throws Exception{
		User user =new User();
		user.setUserName("丁鹏");
		user.setPassWord("iamdp");
		user.setEmail("iamdp123@163.com");
		user.setNickName("恋~蔚蓝的天空^O^");
		jpaUserDao.save(user);
//		Assert.assertEquals(9, jpaUserDao.findAll().size());
//		Assert.assertEquals("iamdp123@163.com", jpaUserDao.findByUserName("丁鹏").getEmail());
		System.out.println(jpaUserDao.findByUserName("丁鹏").getEmail());
	}
}
