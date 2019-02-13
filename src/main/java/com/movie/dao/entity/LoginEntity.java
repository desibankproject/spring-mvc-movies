package com.movie.dao.entity;

import java.sql.Timestamp;

public class LoginEntity {

	private int lid;
	private String username;
	private String password;
	private String role;
	private Timestamp doe;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "LoginEntity [lid=" + lid + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", doe=" + doe + "]";
	}

}
