/**
 * 
 */
package com.ofbis.design;

/**
 * @author ankur.mahajan
 * @written 19-Dec-2018
 */
public class OfbResponse {

	private int responseCode;

	private Object content;

	public OfbResponse(Builder builder) {
		super();
		this.responseCode = builder.responseCode;
		this.content = builder.content;
	}

	static class Builder {

		private int responseCode;

		private Object content;

		/**
		 * @param responseCode
		 *            the responseCode to set
		 */
		public Builder setResponseCode(int responseCode) {
			this.responseCode = responseCode;
			return this;
		}

		/**
		 * @param content
		 *            the content to set
		 */
		public Builder setContent(Object content) {
			this.content = content;
			return this;
		}

		public OfbResponse build() {
			return new OfbResponse(this);
		}

	}

	/**
	 * @return the content
	 */
	public Object getContent() {
		return content;
	}

	/**
	 * @return the responseCode
	 */
	public int getResponseCode() {
		return responseCode;
	}

}
