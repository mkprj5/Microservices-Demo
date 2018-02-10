package com.cca.microservices.currencyexchangeservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Handle when currecy type is okay but that is not found in system
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurrencyNotFoundException extends RuntimeException {
    public CurrencyNotFoundException(String message) {
        super(message);
    }
}
