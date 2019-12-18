package com.xiami.web.socket.web.socket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * WebSocket消息处理器。
 *
 * @author liuxiangquan
 * @since 2018年5月31日
 */
@Component
@Slf4j
public class MyTextWebSocketHandler extends TextWebSocketHandler {

	/**
	 * 新 WebSocket 建立连接触发。
	 *
	 * @param session
	 * @throws Exception
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("afterConnectionEstablished enter, id={}", session.getId());

		session.sendMessage(new TextMessage("You are now connected to the server. This is the first message."));

		log.debug("afterConnectionEstablished leave, id={}", session.getId());
	}

	/**
	 * 收到消息触发。
	 * 
	 * @param session
	 * @param message
	 * @throws Exception
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 获得客户端传来的消息
		String payload = message.getPayload();
		log.debug("server 接收到消息：{}", payload);
		session.sendMessage(new TextMessage("服务器返回消息， hello world"));
	}

	/**
	 * WebSocket 被关闭后触发。
	 *
	 * @param session
	 * @param status
	 * @throws Exception
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.debug("afterConnectionClosed enter, id={}", session.getId());

		log.debug("afterConnectionClosed leave, id={}", session.getId());
	}
}
