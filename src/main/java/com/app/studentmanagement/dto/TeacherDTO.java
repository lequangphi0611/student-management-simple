package com.app.studentmanagement.dto;

import java.util.Date;

/**
 * TeacherDTO
 */
public class TeacherDTO extends PersonDTO {

	private String email;
	private String phone;

	public TeacherDTO() {
		super();
	}

	public TeacherDTO(long id, String name, boolean gender, Date birthday, 
			String email, String phone, boolean status) {
		super(id, name, gender, birthday, status);
		this.email = email;
		this.phone = phone;
	}

	public TeacherDTO(PersonDTO personDTO1, String email, String phone) {
		super(personDTO1);
		this.email = email;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}