package com.nt.ecom.singleton;

public class AuditLogger {

	private static final AuditLogger INSTANCE = new AuditLogger();

	private AuditLogger() {
	}

	public static AuditLogger getInstance() {
		return INSTANCE;
	}

	public void log(String message) {

		System.out.println("AUDIT : " + message);
	}
}