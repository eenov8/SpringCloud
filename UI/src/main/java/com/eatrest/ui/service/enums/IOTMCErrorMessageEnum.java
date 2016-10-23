package com.eatrest.ui.service.enums;

public enum IOTMCErrorMessageEnum {

	INVALID_HEADER_CODE("505"), 
	INVALID_HEADER_MESSAGE("Invalid Header."), 
	SUCCESS_CODE("200"), 
	SUCCESS_MESSAGE("Success"),
	FAILURE_CODE("404"), 
	FAILURE_MESSAGE("Failure"),
	ENCRYPTION_ERROR_CODE("545"), 
	ENCRYPTION_ERROR_MESSAGE("Can not encrypt the challenge."), 
	COMMON_ERROR_CODE("500"), 
	INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),
	BAD_REQUEST("400"),
	INVALID_FILE_HEADER("300"),
	UPLOAD_ERROR("Error while uploading file to server."),
	HEADER_MISMATCH("Headers present in uploaded file are invalid."),
	FILE_PARSE_ERROR("Error while parsing file."),
	BAD_REQUEST_MESSAGE("Invalid Request Parameter."), 
	SUCCESS_REQUEST("Request sent successfully"),
	FORBIDDEN_REQUEST("403"),
	DATABASE_ERROR_MESSAGE("Database Access Failure");
	
	private String value;

	private IOTMCErrorMessageEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}