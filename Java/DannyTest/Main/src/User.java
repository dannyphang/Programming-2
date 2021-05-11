import java.util.*;

public abstract class User {
	private String username;
	private String name;
	private Date registerDate;
	private final static int listingLimit = 5;

	public User(String username, String name, Date registerDate) {
		this.username = username;
		this.name = name;
		this.registerDate = registerDate;
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

	public static int getListinglimit() {
		return listingLimit;
	}

	public static User[] displayUser(int page) {
		return null;
	}
	
}