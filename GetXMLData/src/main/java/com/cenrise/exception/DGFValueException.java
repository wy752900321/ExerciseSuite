package com.cenrise.exception;


public class DGFValueException extends DgfException {
    private static final long serialVersionUID = -7291295387708673883L;
    
    public DGFValueException(String message) {
        super(message);
    }
    
    public DGFValueException(Throwable cause) {
        super(cause);
    }
    
    public DGFValueException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
