package com.isos.isosportal.enums;

public enum ErrorCode {


    PATIENT_ALL_NOT_FOUND("10001","Patient list not found"),
    PATIENT_DELETE_NOT_FOUND("10002","Patient delete not found"),
    PATIENT_BY_ID_NOT_FOUND("10003","Patient list not found"),
    PATIENT_SAVE_ERROR_FOUND("10004","Patient list not found"),
    DOCTOR_ALL_NOT_FOUND("10005","Patient list not found"),
    DOCTOR_DELETE_NOT_FOUND("10006","Patient list not found"),
    DOCTOR_BY_ID_NOT_FOUND("10007","Patient list not found"),
    DOCTOR_SAVE_ERROR_FOUND("10008","Patient list not found");




    private String code;

    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
