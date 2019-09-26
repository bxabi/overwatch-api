package com.bxabi.overwatch;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8807900817363305838L;

	public NotFoundException(String string) {
		super(string);
	}

}
