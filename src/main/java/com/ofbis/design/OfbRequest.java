/**
 * 
 */
package com.ofbis.design;

import java.util.Map;

/**
 * @author ankur.mahajan
 * @written 19-Dec-2018
 */
public class OfbRequest {

	private String methodType;

	private String body;

	private String url;

	private Map<String, String> headers;

	private String tag;

	// Constructor for GET request.
	public OfbRequest(String methodType, String url, Map<String, String> headers, String tag) {
		super();
		this.methodType = methodType;
		this.url = url;
		this.headers = headers;
		this.tag = tag;
	}

	// Constructor for POST and other requests.
	public OfbRequest(String methodType, String body, String url, Map<String, String> headers, String tag) {
		super();
		this.methodType = methodType;
		this.body = body;
		this.url = url;
		this.headers = headers;
		this.tag = tag;
	}

	/**
	 * @return the methodType
	 */
	public String getMethodType() {
		return methodType;
	}

	/**
	 * @param methodType
	 *            the methodType to set
	 */
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * @param headers
	 *            the headers to set
	 */
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

}
