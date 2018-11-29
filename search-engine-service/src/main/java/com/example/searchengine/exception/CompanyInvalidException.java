package com.example.searchengine.exception;

/**
 * This exception is thrown when company name doesn't exists in the system
 */
public class CompanyInvalidException extends Exception {

    private static final long serialVersionUID = 6949447731150358499L;

    public CompanyInvalidException(String msg) {
        super(msg);
    }

    public CompanyInvalidException(String msg, Throwable t) {
        super(msg, t);
    }
}
