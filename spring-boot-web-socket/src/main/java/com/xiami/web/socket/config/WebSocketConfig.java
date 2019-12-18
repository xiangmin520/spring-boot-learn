package com.xiami.web.socket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.xiami.web.socket.web.socket.MyTextWebSocketHandler;
import com.xiami.web.socket.web.socket.WebSocketInterceptor;


/**
 * WebSocket配置
 * 
 * @author xiami
 * @since 2019年12月18日
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Autowired
	private MyTextWebSocketHandler myTextWebSocketHandler;

	@Autowired
	private WebSocketInterceptor webSocketInterceptor;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myTextWebSocketHandler, "/websocket/register").setAllowedOrigins("*").addInterceptors(webSocketInterceptor);
	}
}
