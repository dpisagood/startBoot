package cn.iamdp.startBoot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.iamdp.startBoot.filter.SimpleFilter;

@Configuration
public class WebConfiguration {
 
	@Bean
	public FilterRegistrationBean simpleFilter() {
		FilterRegistrationBean filterRegistration=new FilterRegistrationBean();
		filterRegistration.setFilter(new SimpleFilter());
		filterRegistration.addUrlPatterns("/*");
		filterRegistration.setOrder(1);
		return filterRegistration;
	}
	
}
