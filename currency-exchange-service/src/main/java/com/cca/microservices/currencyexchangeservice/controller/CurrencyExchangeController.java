package com.cca.microservices.currencyexchangeservice.controller;

import com.cca.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.cca.microservices.currencyexchangeservice.exception.CurrencyNotValidException;
import com.cca.microservices.currencyexchangeservice.service.ExchangeValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueService exchangeValueService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        if(from == null || to == null || from.length() != 3 || to.length() != 3) {
            throw new CurrencyNotValidException("Currency is Not Valid" + from + to);
        }



        ExchangeValue exchangeValue = exchangeValueService.findBasedOnCurrency(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("{}", exchangeValue);
        return exchangeValue;
    }

    @GetMapping("currency-exchange/from")
    public List<String> availableCurrencyFrom() {
        return exchangeValueService.currencyFrom();
    }

    @GetMapping("currency-exchange/to")
    public List<String> availableCurrencyTo() {
        return exchangeValueService.currencyTo();
    }
}
