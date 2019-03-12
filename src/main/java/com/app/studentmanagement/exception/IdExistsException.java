package com.app.studentmanagement.exception;

/**
 * IdExistsException
 */
@SuppressWarnings("rawtypes")
public class IdExistsException extends ObjectExistsException {

	private static final long serialVersionUID = 1L;
	
	public IdExistsException(String message) {
		super(message);
	}
	
	public IdExistsException( Class classType, Object id, boolean existsError) {
		super(classType, id, existsError);
	}

	@Override
	public String getMessage() {
		return new StringBuffer("Error : ")
				.append(classType.getName())
				.append(" with id = '")
				.append(id)
				.append("' ")
				.append(existsError ? "is already exists !" : "do not exists!")
				.toString();
	}

}