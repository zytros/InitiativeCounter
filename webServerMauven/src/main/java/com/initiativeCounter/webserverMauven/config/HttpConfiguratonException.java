package com.initiativeCounter.webserverMauven.config;

public class HttpConfiguratonException extends RuntimeException{
    public HttpConfiguratonException() {
    }

    public HttpConfiguratonException(String message) {
        super(message);
    }

    public HttpConfiguratonException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpConfiguratonException(Throwable cause) {
        super(cause);
    }

}
