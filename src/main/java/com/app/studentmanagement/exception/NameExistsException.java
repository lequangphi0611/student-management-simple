package com.app.studentmanagement.exception;

@SuppressWarnings("rawtypes")
public class NameExistsException extends ObjectExistsException {

    private static final long serialVersionUID  = 1L;
	
	public NameExistsException(String message) {
		super(message);
	}
	
	public NameExistsException(Class classType, Object id, boolean existsError) {
		super(classType, id, existsError);
	}

	@Override
	public String getMessage() {
		return new StringBuffer("Error : ")
				.append(classType.getName())
				.append(" with name = '")
				.append(id)
				.append("' ")
				.append(existsError ? "is already exists !" : "do not exists!")
				.toString();
	}
    
}