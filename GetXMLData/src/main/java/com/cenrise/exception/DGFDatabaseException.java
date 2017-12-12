package com.cenrise.exception;


/**
 * 数据库相关
 * 
 * @author  jiadp
 */
public class DGFDatabaseException extends DgfException {

    public static final long serialVersionUID = 0x8D8EA0264F7A1C0FL;
    
	/**
	 * Constructs a new throwable with null as its detail message.
	 */
	public DGFDatabaseException()
	{
		super();
	}

	/**
	 * Constructs a new throwable with the specified detail message.
	 * @param message - the detail message. The detail message is saved for later retrieval by the getMessage() method.
	 */
	public DGFDatabaseException(String message)
	{
		super(message);
	}

	/**
	 * Constructs a new throwable with the specified cause and a detail message of (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).
	 * @param cause the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 */
	public DGFDatabaseException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * Constructs a new throwable with the specified detail message and cause.
	 * @param message the detail message (which is saved for later retrieval by the getMessage() method).
	 * @param cause the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 */
	public DGFDatabaseException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
