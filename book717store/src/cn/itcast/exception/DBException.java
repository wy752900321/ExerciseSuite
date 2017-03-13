package cn.itcast.exception;

/**
 * RuntimeException运行时，不显示在界面上
 * Exception编译时，在界面上显示。当我们要显示在界面上时，要继承Exception
 * 数据库的异常 继承处Exception的异常时，必须在方法上throws。
 * 如果继承自RuntimeException就不用，所以我们常用RuntimeException
 */
@SuppressWarnings("serial")
public class DBException extends RuntimeException {
	public DBException(String message) {
		super(message);
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}
}
