package com.nt.ecom.observer;

public class EmailNotification implements EventListener {

	@Override
	public void update(String event, String message) {

		System.out.println("EMAIL : " + event + " -> " + message);
	}
}