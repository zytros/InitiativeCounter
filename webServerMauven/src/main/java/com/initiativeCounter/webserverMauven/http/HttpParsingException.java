package com.initiativeCounter.webserverMauven.http;

public class HttpParsingException extends Exception{

    private final HttpStatusCodes errorCode;

    public HttpParsingException(HttpStatusCodes errorCode) {
        super(errorCode.MESSAGE);
        this.errorCode = errorCode;
    }

    public HttpStatusCodes getErrorCode() {
        return errorCode;
    }
}
