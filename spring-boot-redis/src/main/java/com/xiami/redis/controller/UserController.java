package com.xiami.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 一句话功能简述。
 *
 * @author zhouxiangmin
 * @since 2019年12月10日
 */
public class UserController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
}
