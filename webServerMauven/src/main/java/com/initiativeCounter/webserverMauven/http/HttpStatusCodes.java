package com.initiativeCounter.webserverMauven.http;

public enum HttpStatusCodes {
    /* --- CLIENT ERRORS --- */
    CLIENT_ERROR_400_BAD_REQUEST(400, "Bade Request"),
    CLIENT_ERROR_401_METHOD_NOT_ALLOWED(401, "Method Not Allowed"),
    CLIENT_ERROR_414_BAD_REQUEST(414, "URI Too Long"),
    /* --- SERVER ERRORS --- */
    SERVER_ERROR_500_INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SERVER_ERROR_501_NOT_IMPLEMENTED(501, "Not Implemented");


    public final int STATUS_CODE;
    public final String MESSAGE;

    HttpStatusCodes(int STATUS_CODE, String MESSAGE) {
        this.STATUS_CODE = STATUS_CODE;
        this.MESSAGE = MESSAGE;
    }
}
