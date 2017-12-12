/**
 * 
 */
package com.cenrise.database.meta;


import com.cenrise.exception.DgfException;
import com.cenrise.exception.DgfException;

/**
 * @author zhangyz
 *
 */
public class ValueException extends DgfException {

	/**
	 * @param msg
	 */
	public ValueException(String msg) {
		super(msg);
	}

	/**
	 * @param msg
	 * @param th
	 */
	public ValueException(String msg, Throwable th) {
		super(msg, th);
	}

	/**
	 * @param th
	 */
	public ValueException(Throwable th) {
		super(th);
	}

}
