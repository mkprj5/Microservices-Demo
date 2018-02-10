package com.cca.microservices.currencyexchangeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// Will handle Bad request, For example Null, Number, NotValid
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CurrencyNotValidException extends RuntimeException {
    public CurrencyNotValidException(String message) {
        super(message);
    }
}
