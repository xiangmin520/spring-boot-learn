package com.xiami.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.xiami.redis.utils.RedisConnectionFactoryUtil;

/**
 * Redis配置类-自定义RedisTemplate。
 *
 * @author zhouxiangmin
 * @since 2019年12月11日
 */
@Configuration
public class RedisConfig {
	
	@Autowired
	private RedisProperties redisProperties;
	
	@Bean
	public StringRedisTemplate stringRedisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
		return new StringRedisTemplate(lettuceConnectionFactory);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(lettuceConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		return redisTemplate;
	}
	
	@Bean
	public LettuceConnectionFactory lettuceConnectionFactory() {
		return RedisConnectionFactoryUtil.createLettuceConnectionFactory(redisProperties);
	}
}
