package com.xiami.web.socket.web.socket;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * websocket 拦截器。
 * 在服务端和客户端在进行握手时会被执行
 *
 * @author xiami
 * @since 2019年12月18日
 */
@Component
@Slf4j
public class WebSocketInterceptor implements HandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) {
		if (log.isTraceEnabled()) {
			log.trace("beforeHandshake enter");

			HttpHeaders requestHeaders = request.getHeaders();
			log.trace("Http Request Headers count: {}", requestHeaders.size());
			Set<Entry<String, List<String>>> reqEntrySet = requestHeaders.entrySet();
			for (Entry<String, List<String>> entry : reqEntrySet) {
				log.trace("{}:{}", entry.getKey(), entry.getValue().toString());
			}

			HttpHeaders responseHeaders = response.getHeaders();
			log.trace("Http Response Headers count: {}", responseHeaders.size());
			Set<Entry<String, List<String>>> rspEntrySet = responseHeaders.entrySet();
			for (Entry<String, List<String>> entry : rspEntrySet) {
				log.trace("{}:{}", entry.getKey(), entry.getValue().toString());
			}

			log.trace("attributes count: {}", attributes.size());
			Set<Entry<String, Object>> attributesEntrySet = attributes.entrySet();
			for (Entry<String, Object> entry : attributesEntrySet) {
				log.trace("{}:{}", entry.getKey(), entry.getValue().toString());
			}

			log.trace("beforeHandshake leave");
		}

		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
		if (log.isTraceEnabled()) {
			log.trace("afterHandshake enter");

			log.trace("exception={0}", exception);

			HttpHeaders requestHeaders = request.getHeaders();
			log.trace("Http Request Headers count: {}", requestHeaders.size());
			Set<Entry<String, List<String>>> reqEntrySet = requestHeaders.entrySet();
			for (Entry<String, List<String>> entry : reqEntrySet) {
				log.trace("{}:{}", entry.getKey(), entry.getValue().toString());
			}

			HttpHeaders responseHeaders = response.getHeaders();
			log.trace("Http Response Headers count: {}", responseHeaders.size());
			Set<Entry<String, List<String>>> rspEntrySet = responseHeaders.entrySet();
			for (Entry<String, List<String>> entry : rspEntrySet) {
				log.trace("{}:{}", entry.getKey(), entry.getValue().toString());
			}

			log.trace("afterHandshake leave");
		}
	}

}
