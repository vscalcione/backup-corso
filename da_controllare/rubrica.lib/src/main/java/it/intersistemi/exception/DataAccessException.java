package it.intersistemi.exception;

public class DataAccessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7112919806162854557L;
	
	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
