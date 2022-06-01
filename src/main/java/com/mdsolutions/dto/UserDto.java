package com.mdsolutions.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserDto {

	private Integer userId;

	@Size(min = 4, max = 50, message = "FirstName should be minof 4 and max of 50 characters")
	private String firstName;

	@Size(min = 4, max = 50, message = "lastName should be minof 4 and max of 50 characters")
	private String lastName;

	@Email(regexp = "^(.+)@(\\S+)$" , message = "Please enter valid mail id")
	private String email;

	private String contactNumber;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + "]";
	}

	public UserDto(Integer userId, String firstName, String lastName, String email, String contactNumber) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	public UserDto() {
	}
}
