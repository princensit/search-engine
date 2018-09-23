package com.example.searchengine.exception;

/**
 * SearchEngineServiceException provides callers several pieces of information that can be used to obtain
 * more information about the error and why it occurred. In particular, the errorType field can be
 * used to determine if the caller's request was invalid, or the service encountered an error on the
 * server side while processing it.
 */
public class SearchEngineServiceException extends SearchEngineClientException {

    private static final long serialVersionUID = 1L;

    /**
     * Indicates who is responsible for a failed request
     */
    public enum ErrorType {
        Client, Service
    }

    private String requestId;

    public SearchEngineServiceException(String message) {
        super(message);
    }

    public SearchEngineServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SearchEngineServiceException(Throwable cause) {
        super(cause);
    }

    public SearchEngineServiceException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
