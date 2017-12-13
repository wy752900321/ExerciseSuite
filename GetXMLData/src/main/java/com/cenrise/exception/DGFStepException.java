package com.cenrise.exception;


public class DGFStepException extends DgfException {
	private static final long serialVersionUID = 1L;

	public DGFStepException(String msg, Throwable th) {
		super(msg, th);
	}

	public DGFStepException(String msg) {
		super(msg);
	}

	public DGFStepException(Throwable th) {
		super(th);
	}

}
