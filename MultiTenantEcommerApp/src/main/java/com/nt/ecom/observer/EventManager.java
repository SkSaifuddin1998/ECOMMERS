package com.nt.ecom.observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

	private final List<EventListener> listeners = new ArrayList<>();

	public void subscribe(EventListener listener) {
		listeners.add(listener);
	}

	public void notifyAllListeners(String event, String message) {

		for (EventListener listener : listeners) {
			listener.update(event, message);
		}
	}
}