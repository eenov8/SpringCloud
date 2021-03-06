/**
 * 
 */
package com.eatrest.office.inventory.management.service.dao.beans;

/**
 * @author AJ
 *
 */
public class AttributeParam {
	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AttributeParam [key=" + key + ", value=" + value + "]";
	}

	public AttributeParam(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public AttributeParam() {
		super();
		// TODO Auto-generated constructor stub
	}

}
