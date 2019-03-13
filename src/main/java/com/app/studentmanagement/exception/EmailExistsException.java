package com.app.studentmanagement.exception;

import com.app.studentmanagement.entity.Teacher;

public class EmailExistsException extends ObjectExistsException {
	
	private static final long serialVersionUID = -677312753685002223L;

	public EmailExistsException(Object email) {
		super(Teacher.class, email, true);
	}

	public EmailExistsException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return new StringBuffer("Error : ")
				.append(classType.getName())
				.append(" with email = '")
				.append(ob)
				.append("' ")
				.append("is already exists !")
				.toString();
	}

}
