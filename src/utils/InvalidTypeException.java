package utils;

public class InvalidTypeException extends RuntimeException {
	public InvalidTypeException() {
		super();
	}
	public InvalidTypeException(String message) {
		super(message);
	}
}