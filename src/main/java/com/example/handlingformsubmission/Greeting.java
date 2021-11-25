package com.example.handlingformsubmission;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Greeting {

	private String id;
	private String password;
	private String name;

	public String getName() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return password;
	}

	public void setContent(String password) {
		this.password = password;
	}

}
