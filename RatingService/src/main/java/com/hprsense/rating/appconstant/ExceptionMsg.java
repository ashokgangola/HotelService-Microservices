package com.hprsense.rating.appconstant;

public enum ExceptionMsg {
	RESOURCE_NOT_FOUND("Resource not found");
	
	public final String label;

    private ExceptionMsg(String label) {
        this.label = label;
    }
}
