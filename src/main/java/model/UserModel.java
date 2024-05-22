package model;

public class UserModel {
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String address;
	private String phoneNumber;
	private String password;
	
	 public UserModel() {
	        super();
	    }
	 public UserModel(String userName, String password) {
		 this.userName = userName;
		this.password = password; 
	 }
	public UserModel(int userId, String firstName, String lastName, String gender, String email,String address, String phoneNumber,
			String username, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userName = username;
		this.password = password;
	}
	public UserModel(String userName, String firstName, String lastName, String gender, String email, String address,
			String phoneNumber, String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public UserModel(String userName, String email, String address, String phoneNumber) {
		super();
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
