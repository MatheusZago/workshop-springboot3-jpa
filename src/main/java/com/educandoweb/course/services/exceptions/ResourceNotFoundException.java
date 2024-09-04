package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	//Está passando o Id que tentou encontrar e não encontrou
	public ResourceNotFoundException(Object id) {
		super("Resource not found. id " + id);
	}

}
