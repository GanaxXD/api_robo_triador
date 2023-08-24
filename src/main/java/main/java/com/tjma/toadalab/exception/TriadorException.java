package main.java.com.tjma.toadalab.exception;

public class TriadorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public TriadorException(String message) {
		this.message = message;
		System.err.println(message);
	}

}
