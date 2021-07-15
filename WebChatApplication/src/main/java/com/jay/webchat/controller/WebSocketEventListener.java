package com.jay.webchat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.jay.webchat.model.ChatMessage;
import com.jay.webchat.model.Message;

@Component
public class WebSocketEventListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);
	
	@Autowired
	private SimpMessageSendingOperations sendingOperations;
	
	@EventListener
	public void handleWebSocketConnectListener(final SessionConnectedEvent event) {
		LOGGER.info("New Connection has been made");
		
	}
	
	@EventListener
	public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event) {
		final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		final String username = (String) headerAccessor.getSessionAttributes().get("username");
		
		final ChatMessage chatMessage = new ChatMessage(Message.DISCONNECT, username);
		
		sendingOperations.convertAndSend("/topic/public", chatMessage);
	}
	
	
}
