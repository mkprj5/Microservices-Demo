package com.cca.microservices.currencyexchangeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Will handle bad quantity request, like negative quantity, String value
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuantityNotValidException extends RuntimeException {
    public QuantityNotValidException(String message) {
        super(message);
    }
}
