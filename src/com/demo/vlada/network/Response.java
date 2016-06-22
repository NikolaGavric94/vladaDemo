package com.demo.vlada.network;

public class Response {
	private String result;
	
	public Response(Object result) {
		this.result = result.toString();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
