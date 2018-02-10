package com.cca.microservices.currencyexchangeservice.repo;

import com.cca.microservices.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);

//    @Query("select DISTINCT OBJECT (currency_from) from exchange_value")
//    List<String> findDistinctCurrencyFrom();

//    @Query("select DISTINCT OBJECT (currency_from) from exchange_value")
//    List<String> findDistinctCurrencyTo();

    public static final String FIND_UNQ_CUR_FROM = "SELECT DISTINCT currency_from FROM exchange_value";
    public static final String FIND_UNQ_CUR_TO = "SELECT DISTINCT currency_to FROM exchange_value";

    @Query(value = FIND_UNQ_CUR_FROM, nativeQuery = true)
    public List<String> findDistinctCurrencyFrom();


    @Query(value = FIND_UNQ_CUR_TO, nativeQuery = true)
    public List<String> findDistinctCurrencyTo();

}
