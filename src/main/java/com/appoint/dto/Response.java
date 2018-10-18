package com.appoint.dto;

public class Response {

	private String status;
	private String msg;
	private Object obj;

	public Response() {	
	}
	
	public Response(String msg, String status, Object obj) {
		this.msg = msg;
		this.status = status;
		this.obj = obj;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
