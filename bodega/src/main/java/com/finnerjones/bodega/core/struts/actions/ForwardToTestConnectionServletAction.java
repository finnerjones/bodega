package com.finnerjones.bodega.core.struts.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class ForwardToTestConnectionServletAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> request;

	@Override
	public String execute() throws Exception {
		// nothing to do here
		return "success";
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

}
