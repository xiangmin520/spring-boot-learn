/*
 * Filename	RedisConnectionFactoryUtil.java 2019年8月20日
 * Copyright © Suzhou Keda Technology Co.Ltd. All Rights Reserved.
 * @author	yanglei
 */
package com.xiami.redis.utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.util.ObjectUtils;

/**
 * Redis连接工程工具类。
 *
 * @author xiami
 * @since 2019年12月11日
 */
public class RedisConnectionFactoryUtil {

	/**
	 * 创建LettuceConnectionFactory。
	 *
	 * @param properties
	 * @return
	 * @since 2019年8月22日
	 */
	public static LettuceConnectionFactory createLettuceConnectionFactory(RedisProperties properties) {

		/* ========= 单机版基本配置 ========= */
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
		configuration.setHostName(properties.getHost());
		configuration.setPort(properties.getPort());
		if (!ObjectUtils.isEmpty(properties.getDatabase())) {
			configuration.setDatabase(properties.getDatabase());
		}
		if (!ObjectUtils.isEmpty(properties.getPassword())) {
			RedisPassword redisPassword = RedisPassword.of(properties.getPassword());
			configuration.setPassword(redisPassword);
		}

		/* ========= 连接池通用配置 ========= */
		GenericObjectPoolConfig<?> poolConfig = new GenericObjectPoolConfig<>();
		poolConfig.setMaxTotal(properties.getLettuce().getPool().getMaxActive());
		poolConfig.setMaxIdle(properties.getLettuce().getPool().getMaxIdle());
		poolConfig.setMinIdle(properties.getLettuce().getPool().getMinIdle());
		poolConfig.setMaxWaitMillis(properties.getLettuce().getPool().getMaxWait().toMillis());

		/* ========= lettuce pool ========= */
		LettuceClientConfiguration clientConfig = LettucePoolingClientConfiguration.builder()
				.poolConfig(poolConfig)
				.build();
		return new LettuceConnectionFactory(configuration, clientConfig);
	}
}
