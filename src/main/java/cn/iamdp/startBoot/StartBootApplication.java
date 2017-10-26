package cn.iamdp.startBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * spring boot启动方式
 */
@SpringBootApplication
public class StartBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartBootApplication.class, args);
	}
}


/**
 * 打成war要提供一个注册启动类，外部web应用服务器构建Web Application Context的时候，会把启动类添加进去。
 * @author DP
 *
 */
//@SpringBootApplication
//public class StartBootApplication extends SpringBootServletInitializer{
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(StartBootApplication.class);
//	}
//	
//	public static void main(String[] args) {
//		SpringApplication.run(StartBootApplication.class, args);
//	}
//}