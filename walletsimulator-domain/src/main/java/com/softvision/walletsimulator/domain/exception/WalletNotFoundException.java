package com.softvision.walletsimulator.domain.exception;

import com.softvision.walletsimulator.domain.exception.utils.ExceptionCodes;
import org.springframework.http.HttpStatus;

import static java.lang.String.format;

public class WalletNotFoundException extends RuntimeException {
    private HttpStatus httpStatus;
    private String code;

    public WalletNotFoundException(String message) {
        super(message);
    }

    public WalletNotFoundException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public WalletNotFoundException(ExceptionCodes exceptionCode, String... args) {
        super(format(exceptionCode.desc(), args));
        this.httpStatus = exceptionCode.httpCode();
        this.code = exceptionCode.code();

    }



}
