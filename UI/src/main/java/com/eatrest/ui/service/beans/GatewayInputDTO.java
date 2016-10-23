/**
 * 
 */
package com.eatrest.ui.service.beans;

/**
 * @author Harman
 *
 */
public class GatewayInputDTO {
	private String url;
	private String reqType;
	private String data;

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
	 * @return the reqType
	 */
	public String getReqType() {
		return reqType;
	}

	/**
	 * @param reqType
	 *            the reqType to set
	 */
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GatewayInputDTO [url=" + url + ", reqType=" + reqType + ", data=" + data + ", getUrl()=" + getUrl()
				+ ", getReqType()=" + getReqType() + ", getData()=" + getData() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	/**
	 * @param url
	 * @param reqType
	 * @param data
	 */
	public GatewayInputDTO(String url, String reqType, String data) {
		super();
		this.url = url;
		this.reqType = reqType;
		this.data = data;
	}

	/**
	 * 
	 */
	public GatewayInputDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
