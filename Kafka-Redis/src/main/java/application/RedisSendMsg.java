package application;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisSendMsg {
	private final RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	public RedisSendMsg(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public void saveMessage(String message) {
		String redisKey = "Key:" + String.valueOf(System.currentTimeMillis()).substring(7);
		
		String procMessage = message + " - From Kafka";
		redisTemplate.opsForValue().set(redisKey, procMessage);
		
		redisTemplate.expire(redisKey, 15, TimeUnit.MINUTES);
	
		System.out.println("Сообщение: " + message + " сохранено с ключом: " + redisKey);
	}
}
