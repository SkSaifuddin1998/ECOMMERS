package com.erp.service.user.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final String message;

	public BusinessException(String message) {
        super(message);
        this.message = message;
    }
}