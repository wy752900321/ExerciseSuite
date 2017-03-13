package exception;

@SuppressWarnings("serial")
public class HeightLimitException extends Exception {
	public HeightLimitException() {
		super();
	}

	public HeightLimitException(String message) {
		super(message);
	}

	public HeightLimitException(String message, Throwable cause) {
		super(message, cause);
	}

	public HeightLimitException(Throwable cause) {
		super(cause);
	}
}
