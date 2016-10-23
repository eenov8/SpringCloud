package com.eatrest.ui.service.enums;

public enum GatewayRoutesEnum {

	LOGIN_URL("IRUSERMANAGER/IndusRoot/users/authenticate");
	
	private String value;

	private GatewayRoutesEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}