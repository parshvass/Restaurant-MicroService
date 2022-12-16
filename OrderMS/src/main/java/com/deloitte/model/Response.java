package com.deloitte.model;

public class Response {
	private String msg;
	private Object obj;

	public Response() {
		super();
	}

	public Response(String msg) {
		super();
		this.msg = msg;
	}

	public Response(Object obj, String msg) {
		super();
		this.obj = obj;
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Response(Object obj) {
		super();
		this.obj = obj;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
