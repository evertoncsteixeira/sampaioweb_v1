package br.com.sampaio.exception;

public class LoginExistsException extends Exception {
	
	public LoginExistsException(String message) {
		super(message);
	}

	private static final long serialVersionUID =1L;
}
