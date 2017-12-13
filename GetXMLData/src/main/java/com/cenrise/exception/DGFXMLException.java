package com.cenrise.exception;



/**
 * xml处理相关异常
 * @author  Admin
 */
public class DGFXMLException extends DgfException {
    private static final long serialVersionUID = 1L;
    
    public DGFXMLException(String message) {
        super(message);
    }
    
    public DGFXMLException(Throwable cause) {
        super(cause);
    }
    
    public DGFXMLException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
