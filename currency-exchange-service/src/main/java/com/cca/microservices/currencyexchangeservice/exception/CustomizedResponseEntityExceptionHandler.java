package com.cca.microservices.currencyexchangeservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        logException(exceptionResponse);
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CurrencyNotFoundException.class)
    public final ResponseEntity<Object> handleBusNotFoundException(CurrencyNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        logException(exceptionResponse);
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CurrencyNotValidException.class)
    public final ResponseEntity<Object> handleCurrencyNotValidException(CurrencyNotValidException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        logException(exceptionResponse);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(QuantityNotValidException.class)
    public final ResponseEntity<Object> handleQuantityNotValidException(QuantityNotValidException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        logException(exceptionResponse);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    public void logException(ExceptionResponse exceptionResponse) {
        logger.info("{}", exceptionResponse);
    }

}
