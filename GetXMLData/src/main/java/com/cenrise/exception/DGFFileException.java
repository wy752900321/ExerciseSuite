package com.cenrise.exception;


public class DGFFileException extends DgfException {
    private static final long serialVersionUID = 8381518163354400590L;
    
    public DGFFileException(String message) {
        super(message);
    }
    
    public DGFFileException(Throwable cause) {
        super(cause);
    }
    
    public DGFFileException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
