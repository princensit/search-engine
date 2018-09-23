package com.example.searchengine.exception;

/**
 * It indicates that a problem occurred inside the Java client code, either while trying to send a
 * request to server or while trying to parse a response from server.
 *
 * It is generally more severe than SearchEngineServiceException, in a way that client is prevented for
 * making call to server. For example this exception is thrown when there is no network connection
 * available.
 *
 * Callers should typically deal with exceptions through SearchEngineServiceException, which represent
 * error responses returned by services. SearchEngineServiceException has much more information available
 * for callers to appropriately deal with different types of errors that can occur.
 *
 * @see SearchEngineServiceException
 */
public class SearchEngineClientException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SearchEngineClientException(String message) {
        super(message);
    }

    public SearchEngineClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public SearchEngineClientException(Throwable cause) {
        super(cause);
    }

    public SearchEngineClientException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Default is true but subclass may override.
     *
     * @return flag if this exception is retryable or not
     */
    public boolean isRetryable() {
        return true;
    }
}
