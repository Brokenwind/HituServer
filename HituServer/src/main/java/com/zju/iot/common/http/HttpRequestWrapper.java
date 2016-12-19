package com.zju.iot.common.http;

import java.util.HashMap;
import java.util.Map;


public class HttpRequestWrapper {

	private String url;
	private HttpMethod method = HttpMethod.GET;
	private Map<String, String> headers;
	private Map<String, Object> parameters;

	public HttpRequestWrapper(HttpMethod method, String url) {
		this(method, url, null);
	}

	public HttpRequestWrapper(HttpMethod method, String url, Map<String, Object> parameters) {
		if (url == null) {
			throw new NullPointerException("Request url must not be null!");
		}

		if (method != null){
			this.method = method;
		}
		this.url = url;

		this.parameters = parameters;
		if (this.parameters == null) {
			this.parameters = new HashMap<String, Object>();
		}
		this.headers = new HashMap<String, String>();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}


	public Map<String, String> getHeaders() {
		return headers;
	}

	public final String getHeader(String name) {
		return headers.get(name);
	}

	public void addHeaders(Map<String, String> headers) {
		if (headers == null) {
			return;
		}
		this.headers.putAll(headers);
	}

	public void addHeader(String name, String value) {
		headers.put(name, value);
	}

	public void clearHeaders() {
		headers.clear();
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void addParameters(Map<String, ? extends Object> params) {
		if (params == null) {
			return;
		}
		this.parameters.putAll(params);
	}

	public void addParameter(String name, String value) {
		parameters.put(name, value);
	}

	public void addParameter(String name, Object value) {
		parameters.put(name, value);
	}

	public Object getParameter(String name) {
		return parameters.get(name);
	}

	public void removeParameter(String name) {
		parameters.remove(name);
	}

	public void clearParameters() {
		parameters.clear();
	}
}
