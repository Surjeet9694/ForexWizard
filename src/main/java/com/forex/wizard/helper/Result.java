package com.forex.wizard.helper;

public class Result {
	 private float message_id;
	 Sender_chat Sender_chatObject;
	 Chat ChatObject;
	 private float date;
	 private String text;


	 // Getter Methods 

	 public float getMessage_id() {
	  return message_id;
	 }

	 public Sender_chat getSender_chat() {
	  return Sender_chatObject;
	 }

	 public Chat getChat() {
	  return ChatObject;
	 }

	 public float getDate() {
	  return date;
	 }

	 public String getText() {
	  return text;
	 }

	 // Setter Methods 

	 public void setMessage_id(float message_id) {
	  this.message_id = message_id;
	 }

	 public void setSender_chat(Sender_chat sender_chatObject) {
	  this.Sender_chatObject = sender_chatObject;
	 }

	 public void setChat(Chat chatObject) {
	  this.ChatObject = chatObject;
	 }

	 public void setDate(float date) {
	  this.date = date;
	 }

	 public void setText(String text) {
	  this.text = text;
	 }
	}