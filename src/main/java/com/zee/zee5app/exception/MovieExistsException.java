package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class MovieExistsException extends Exception {

	public MovieExistsException(String msg) {
		super(msg);
	}
}
