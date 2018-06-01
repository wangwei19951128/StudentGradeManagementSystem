package com.model;

public class KeyValueS {
	private String id;
	private String name;

	public KeyValueS(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return id + " " + name;
	}
}
