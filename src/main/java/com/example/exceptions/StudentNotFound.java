package com.example.exceptions;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StudentNotFound extends RuntimeException {


	String resourceName;
	String fieldName;
	long fieldValue;

	public StudentNotFound(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s:%s", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}


}
