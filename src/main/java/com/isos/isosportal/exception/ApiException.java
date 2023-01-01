package com.isos.isosportal.exception;

public class ApiException extends  Exception {

    private static final long serialVersionUID =1L;
    private final String errorCode;

    private final String errorMessage;

    public ApiException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
