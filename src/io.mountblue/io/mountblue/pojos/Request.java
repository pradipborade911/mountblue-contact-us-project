package io.mountblue.pojos;

public class Request {
	private int id;
	private String fullName;
	private String email;
	private String message;
	private String status;
	
	public int getId() {
		return id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
