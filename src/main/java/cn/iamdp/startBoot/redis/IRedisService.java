package cn.iamdp.startBoot.redis;

import java.util.List;

/**
 * redis服务类接口
 * @author DP
 *
 */
public interface IRedisService {
	
	public boolean set(String key,String value);
	public String get(String key);
	public boolean expire(String key,String value);
	public <T> boolean setList(String key,List<T> list);
	public <T> List<T> getList(String key,Class<T> clz);
	public <T> T getObject(String key,Class<T> clz);
	public <T> boolean setObject(String key,T objcet);
	
	
	
}
