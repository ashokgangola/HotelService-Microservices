package com.hprsense.user.service.appconstant;

public enum SERVICE {
	HOTEL_SERVICE("HOTEL-SERVICE"),RATING_SERVICE("RATING-SERVICE"),USER_SERVICE("USER-SERVICE");
	public final String label;

    private SERVICE(String label) {
        this.label = label;
    }
}
