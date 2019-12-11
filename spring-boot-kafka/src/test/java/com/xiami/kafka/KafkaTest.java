package com.xiami.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xiami.kafka.entity.User;
import com.xiami.kafka.producer.Producer;

/**
 * kafka测试类。
 *
 * @author xiami
 * @since 2019年12月11日
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class KafkaTest {

	@Autowired
	private Producer producer;

	/**
	 * 测试往kafka发送1000条消息，看消息是否能够被正常发布与消费
	 * 可能会遇到错误：Caused by: java.lang.IllegalStateException: Topic(s) [user] is/are not present and missingTopicsFatal is true
	 * 解决：先用kafka命令创建 主题 user
	 */
	@Test
	public void testSendMsg() {
		for (int i = 0; i < 1000; i++) {
			User user = new User(i + 1, "xiami" + i, 26);
			producer.sendMessage(user);
		}
	}
}
