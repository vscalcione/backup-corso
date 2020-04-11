package it.intersistemi.exception;

public class IncorrectResultSizeException extends DataAccessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -35564970761851793L;
	private int expectedSize;
	private int actualSize;
	
	public IncorrectResultSizeException(int expectedSize) {
		super("expected size "+expectedSize);
		this.expectedSize = expectedSize; 
	}
	public IncorrectResultSizeException(int expectedSize, int actualSize) {
		this(expectedSize);
		this.actualSize =actualSize;
	}
	public int getExpectedSize() {
		return expectedSize;
	}
	public int getActualSize() {
		return actualSize;
	}
}
