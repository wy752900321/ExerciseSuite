package com.cenrise.exception;


public class DGFEOFException extends DgfException {
    
    private static final long serialVersionUID = 1L;
    
    public DGFEOFException(String message) {
        super(message);
    }
    
    public DGFEOFException(Throwable cause) {
        super(cause);
    }
    
    public DGFEOFException(String message, Throwable cause) {
        super(message, cause);
    }
}
