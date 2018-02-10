package com.cca.microservices.currencyexchangeservice.service;

import com.cca.microservices.currencyexchangeservice.entity.ExchangeValue;

import java.util.List;

public interface ExchangeValueService {
    public ExchangeValue findBasedOnCurrency(String from, String to);

    public List<String> currencyFrom();

    public List<String> currencyTo();
}
