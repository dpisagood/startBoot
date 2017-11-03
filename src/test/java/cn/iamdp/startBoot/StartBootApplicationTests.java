package cn.iamdp.startBoot;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import cn.iamdp.startBoot.jpa.dao.JpaUserDao;
import cn.iamdp.startBoot.jpa.entity.User;
import cn.iamdp.startBoot.mybatis.dao.StudentDao;
import cn.iamdp.startBoot.mybatis.pojo.Student;

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
	
	
	
	
	
	   	@Autowired
	    private StringRedisTemplate stringRedisTemplate;
	    
		@Autowired
		private RedisTemplate redisTemplate;

	    @Test
	    public void test() throws Exception {
	        stringRedisTemplate.opsForValue().set("aaa", "111");
	        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	    }
	    
	    @Test
	    public void testObj() throws Exception {
			User user =new User();
			user.setUserName("丁鹏");
			user.setPassWord("iamdp");
			user.setEmail("iamdp123@163.com");
			user.setNickName("恋~蔚蓝的天空^O^");
	        ValueOperations<String, User> operations=redisTemplate.opsForValue();
	        operations.set("iamdp", user);
	        operations.set("iamdp1", user,1,TimeUnit.SECONDS);
	        Thread.sleep(1000);
	        //redisTemplate.delete("com.neo.f");
	        boolean exists=redisTemplate.hasKey("iamdp1");
	        if(exists){
	        	System.out.println("exists is true");
	        }else{
	        	System.out.println("exists is false");
	        }
	       // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
	    }
	    
	    @Test
	    public void getObjectTest() {
	    	ValueOperations<String, User> valueop=redisTemplate.opsForValue();
	    	User user=valueop.get("iamdp");
	    	System.out.println(user);
	    }
	    
	    
	    
	    @Autowired
	    private StudentDao sdao;
	    
	    @Test
	    public void addStudent() {
	    	Student student=new Student();
	    	student.setName("丁鹏");
	    	student.setAge(23);
	    	student.setSex("男");
	    	student.setStudentid(2014014116);
	    	sdao.save(student);
//	    	sdao.insert(student);
	    }
}
