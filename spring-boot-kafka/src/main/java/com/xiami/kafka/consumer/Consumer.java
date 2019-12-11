package com.xiami.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 消费者。
 *
 * @author xiami
 * @since 2019年12月11日
 */
@Component
@Slf4j
public class Consumer {
	
	@KafkaListener(topics = "user", groupId = "springboot-group1")
	public void consume(String msg) {
		log.info("## consume message: {}", msg);
	}
}
