package com.cca.microservices.currencyexchangeservice.service;

import com.cca.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.cca.microservices.currencyexchangeservice.exception.CurrencyNotFoundException;
import com.cca.microservices.currencyexchangeservice.repo.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExchangeValueServiceImpl implements ExchangeValueService {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @Override
    public ExchangeValue findBasedOnCurrency(String from, String to) {
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        if(exchangeValue == null) {
            throw new CurrencyNotFoundException("Either currency_from or currency_to is not found" + from + to);
        }
        return exchangeValue;
    }

    @Override
    public List<String> currencyFrom() {
        List<String> currencyFromList =  exchangeValueRepository.findDistinctCurrencyFrom();
        return currencyFromList;
    }

    @Override
    public List<String> currencyTo() {
        List<String> currencyToList =  exchangeValueRepository.findDistinctCurrencyTo();
        return currencyToList;
    }
}
