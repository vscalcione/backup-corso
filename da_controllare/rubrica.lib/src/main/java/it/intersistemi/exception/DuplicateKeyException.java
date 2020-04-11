package it.intersistemi.exception;

public class DuplicateKeyException extends DataAccessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5114461847495829809L;

	public DuplicateKeyException(String message) {
		super(message);
	}

	public DuplicateKeyException(String message, Throwable cause) {
		super(message, cause);
	}

}
