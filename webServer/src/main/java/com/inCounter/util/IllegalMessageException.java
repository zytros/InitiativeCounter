package com.inCounter.util;

public class IllegalMessageException extends IllegalArgumentException{
    public IllegalMessageException() {
        super();
    }

    public IllegalMessageException(String s) {
        super(s);
    }

    public IllegalMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMessageException(Throwable cause) {
        super(cause);
    }
}
