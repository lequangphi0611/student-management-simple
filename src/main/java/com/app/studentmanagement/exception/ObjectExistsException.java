package com.app.studentmanagement.exception;

@SuppressWarnings("rawtypes")
public abstract class ObjectExistsException extends Error {
	
	private static final long serialVersionUID = 3026488009076036036L;
	
	protected Class classType;
	protected Object id;
	protected boolean existsError = true;

	public ObjectExistsException(String message) {
		super(message);
	}
	
	public ObjectExistsException( Class classType, Object id, boolean existsError) {
		this.classType = classType;
		this.id = id;
		this.existsError = existsError;
	}
	
	@Override
	public abstract String getMessage();
}
