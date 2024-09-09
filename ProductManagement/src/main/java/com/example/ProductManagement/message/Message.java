package com.example.ProductManagement.message;

public class Message {
	
	private Message() {
		
	}
	
	public static String update() {
		return "Event updated Successfully..!";
	}
	
	public static String notUpdated() {
		return "Event not updated...";
	}
	
	public static String errorMessage() {
		return "Something went wrong...";
	}

}
