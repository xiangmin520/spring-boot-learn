package com.xiami.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.google.gson.Gson;
import com.xiami.kafka.entity.User;

import lombok.extern.slf4j.Slf4j;

/**
 * 生产者。
 *
 * @author xiami
 * @since 2019年12月11日
 */
@Component
@Slf4j
public class Producer {

	/** 消息TOPIC */
	private static final String TOPIC = "user";
	
	private static final Gson gson = new Gson();
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(User user) {
		String msg = gson.toJson(user);
		// 发送消息，用户类的 json 作为消息体
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, msg);

		// 监听回调
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onFailure(Throwable throwable) {
				log.info("## Send message fail ..., msg: {}", msg);
			}

			@Override
			public void onSuccess(SendResult<String, String> stringStringSendResult) {
				log.info("## Send message success ..., msg: {}", msg);
			}
		});
	}
}
