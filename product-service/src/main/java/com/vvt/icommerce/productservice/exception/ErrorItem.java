package com.vvt.icommerce.productservice.exception;

public class ErrorItem {
    private String errorCode;
    private String message;

    public void setCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
