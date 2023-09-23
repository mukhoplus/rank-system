package com.mukho.ranksystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@Column(name = "id", length = 20)
	private String id;

	@Column(name = "password", length = 20)
	private String password;

	@Column(name = "name", length = 10)
	private String name;

	@Column(name = "permission", length = 5)
	private String permission = "false";

	public User() {

	}

	public User(String id, String password, String name, String permission) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.permission = permission;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
}
