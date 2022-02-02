package com.zee.zee5app.exception;
import lombok.ToString;

@ToString(callSuper = true)
public class NameNotFoundEception extends Exception {
	public NameNotFoundEception(String message) {
		super(message);

}
}