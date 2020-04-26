package com.softvision.walletsimulator.domain.exception.utils;

import org.springframework.http.HttpStatus;

public enum ExceptionCodes {

    // 404
    WALLET_NOT_FOUND("404400", "Wallet with id %s not found", HttpStatus.NOT_FOUND);

    private String code;

    private String description;

    private HttpStatus httpStatusCode;

    ExceptionCodes(String code, String description, HttpStatus httpStatusCode) {
        this.code = code;
        this.description = description;
        this.httpStatusCode = httpStatusCode;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return description;
    }

    public HttpStatus httpCode() {
        return httpStatusCode;
    }

}
