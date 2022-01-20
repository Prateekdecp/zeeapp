package exception;

import lombok.ToString;

@ToString
public class InvalidEmailException extends Exception {
	public InvalidEmailException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
