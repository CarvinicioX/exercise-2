package com.sap.exercise.todo.entity;

public class Response {

	private Object response;
	private Enum httpStatus;

	public Response(Object response, Enum httpStatus) {
		this.response = response;
		this.httpStatus = httpStatus;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public Enum getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Enum httpStatus) {
		this.httpStatus = httpStatus;
	}

}
