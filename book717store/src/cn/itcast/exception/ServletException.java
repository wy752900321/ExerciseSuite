package cn.itcast.exception;
/**
 *		数据层的异常 
 */
@SuppressWarnings("serial")
public class ServletException extends RuntimeException {
	public ServletException(final String message) {
		super(message);
	}

	public ServletException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
