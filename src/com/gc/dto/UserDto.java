/**
 * 
 */
package com.gc.dto;

import java.io.Serializable;

/**
 * @author Serhiy Bardysh
 *
 */
public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String firstName;	
	private String lastName;
	private String email;
	private int phoneNum;
	private String userPassword;
	
	public UserDto(){
		
	}

	public UserDto(String firstName, String lastName, String email, int phoneNum, String userPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNum = phoneNum;
		this.userPassword = userPassword;
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

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getuserPassword() {
		return userPassword;
	}

	public void setuserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserDto [firstName" + firstName + ", lastName" + lastName + ", email" + email + ", phoneNum"
				+ phoneNum + ", userPassword" + userPassword + "]";
	}
	
	
}
