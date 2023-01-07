package com.forex.wizard.helper;

public class Chat {
	 private float id;
	 private String title;
	 private String username;
	 private String type;
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chat(float id, String title, String username, String type) {
		super();
		this.id = id;
		this.title = title;
		this.username = username;
		this.type = type;
	}
	public float getId() {
		return id;
	}
	public void setId(float id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Chat [id=" + id + ", title=" + title + ", username=" + username + ", type=" + type + "]";
	}

	}