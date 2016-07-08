package com.ted.w2e;

public class Column {
	private String name;
	private String value;
	
	public Column(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "[" + this.name + "=" + this.value + "]";
	}
}
