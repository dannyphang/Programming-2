package template;

import java.util.*;

import util.Utility;

public abstract class User {
	private String username;
	private String name;
	private Date registerDate;

	public User(String username, String name) {
		this.username = username;
		this.name = Utility.capitalizeName(name);
		registerDate = new Date();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getName(String name) {
		return name;
	}
}