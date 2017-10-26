package cn.iamdp.startBoot.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching  
public class RedisConfig {
	
	
		/**
		 * 配置缓存管理
		 * @param redisTemplate
		 * @return
		 */
	  	@Bean  
	    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {  
	        RedisCacheManager manager = new RedisCacheManager(redisTemplate); 
//	        manager.setDefaultExpiration(0);
	        return manager;  
	    }  
	  

	  
	    /**
	     * key的生成策略
	     * @return
	     */
		@Bean
		public KeyGenerator keyGenerator() {
	        return new KeyGenerator() {
	            @Override
	            public Object generate(Object target, Method method, Object... params) {
	                StringBuilder sb = new StringBuilder();
	                sb.append(target.getClass().getName());
	                sb.append(method.getName());
	                for (Object obj : params) {
	                    sb.append(obj.toString());
	                }
	                return sb.toString();
	            }
	        };
	    } 
	
	  	/**
	  	 * 配置spring boot默认提供的redis模板类，相当于jdbcTemplate,并设置自己的序列化方式
	  	 * 
	  	 * @param connectionFactory
	  	 * @return
	  	 */
	    @Bean  
	    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {  
	        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();  
	        template.setConnectionFactory(connectionFactory);  
	        this.setMySerializer(template);  
	        template.afterPropertiesSet();  
	        return template;  
	    }  
	  
		
		
		
	    /** 
	     * 设置序列化方法 
	     */  
	    private void setMySerializer(RedisTemplate<?, ?> template) {  
	        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(  
	                Object.class);  
	        ObjectMapper om = new ObjectMapper();  
	        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
	        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
	        jackson2JsonRedisSerializer.setObjectMapper(om);  
	        template.setKeySerializer(template.getStringSerializer());//设置key的序列化方式为spring boot redis模板里面自带的字符串序列化方式 
	        template.setValueSerializer(jackson2JsonRedisSerializer);//设置value的序列方式为jackson提供的序列方式。
	    }
}
