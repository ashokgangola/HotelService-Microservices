package com.hprsense.rating.exception;

import com.hprsense.rating.appconstant.ExceptionMsg;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8974209063847828727L;
	
	public ResourceNotFoundException() {
		super(ExceptionMsg.RESOURCE_NOT_FOUND.label);
	}
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
