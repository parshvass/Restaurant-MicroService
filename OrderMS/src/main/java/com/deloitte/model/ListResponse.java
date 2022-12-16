package com.deloitte.model;

import java.util.List;

public class ListResponse {
	private String msg;
	private List<?> objList;
	
	public ListResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListResponse(String msg, List<?> objList) {
		super();
		this.msg = msg;
		this.objList = objList;
	}

	public ListResponse(String msg) {
		super();
		this.msg = msg;
	}

	public ListResponse(List<?> objList) {
		super();
		this.objList = objList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<?> getObjList() {
		return objList;
	}

	public void setObjList(List<?> objList) {
		this.objList = objList;
	}

	@Override
	public String toString() {
		return "ListResponse [msg=" + msg + ", objList=" + objList + "]";
	}
	
	
	
}
