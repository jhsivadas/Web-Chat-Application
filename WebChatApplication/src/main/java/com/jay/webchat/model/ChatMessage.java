package com.jay.webchat.model;

public class ChatMessage {
	
	private Message type;
	private String content;
	private String sender;
	private String time;
	
	public ChatMessage(Message type, String content) {
		super();
		this.type = type;
		this.content = content;
	}

	public Message getType() {
		return type;
	}

	public void setType(Message type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
