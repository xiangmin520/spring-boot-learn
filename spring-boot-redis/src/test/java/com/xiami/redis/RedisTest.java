package com.xiami.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.xiami.redis.entity.User;

/**
 * SpringBoot整合Redis快速入门。
 *
 * @author xiami
 * @since 2019年12月10日
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 1. 测试redis操作String类型数据。
	 */
	@Test
	public void testSetString() {
		stringRedisTemplate.opsForValue().set("hello", "world!.....");

		String hello = stringRedisTemplate.opsForValue().get("hello");
		System.out.println(hello);

		// 试着获取下Redis中不存在的key
		String notExist = stringRedisTemplate.opsForValue().get("not exist");
		System.out.println(notExist);
	}

	/**
	 * 测试RedisTemplate
	 */
	@Test
	public void testObject() {
		User user = new User(1, "xiami", 26);
		redisTemplate.opsForValue().set("user1", user);

		User user1 = (User) redisTemplate.opsForValue().get("user1");
		System.out.println(user1.getUsername());
	}
}
