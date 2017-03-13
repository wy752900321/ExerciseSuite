package cn.itcast.exception;
/**
 * dao²ãµÄÒì³£
 * @author soft01
 *
 */
@SuppressWarnings("serial")
public class DaoException extends RuntimeException {
	public DaoException(String message) {
		super(message);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}
}
