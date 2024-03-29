package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
	public String getMessage() {
		return message;
	}

	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
