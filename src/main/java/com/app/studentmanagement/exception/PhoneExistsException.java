package com.app.studentmanagement.exception;

import com.app.studentmanagement.entity.Teacher;

public class PhoneExistsException extends ObjectExistsException {
	
	private static final long serialVersionUID = -6994458208532702568L;

	public PhoneExistsException(String message) {
		super(message);
	}

	public PhoneExistsException(Object phone) {
		super(Teacher.class, phone, true);
	}

	@Override
	public String getMessage() {
		return new StringBuffer("Error : ")
				.append(classType.getName())
				.append(" with phone = '")
				.append(ob)
				.append("' ")
				.append("is already exists !")
				.toString();
	}

}
