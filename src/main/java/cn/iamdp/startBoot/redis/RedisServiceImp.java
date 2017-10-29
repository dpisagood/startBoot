package cn.iamdp.startBoot.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RedisServiceImp implements IRedisService {

	@Autowired
	private RedisTemplate<String ,?> redisTemplate;
	
	@Override
	public boolean set(String key, String value) {
	     boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
	            @Override  
	            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {  
	                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
	                connection.set(serializer.serialize(key), serializer.serialize(value));  
	                return true;  
	            }  
	        });  
	        return result;  
	}

	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean expire(String key, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> boolean setList(String key, List<T> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> List<T> getList(String key, Class<T> clz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getObject(String key, Class<T> clz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> boolean setObject(String key, T objcet) {
		// TODO Auto-generated method stub
		return false;
	}

}
