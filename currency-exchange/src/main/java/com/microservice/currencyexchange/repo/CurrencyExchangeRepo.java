package com.microservice.currencyexchange.repo;

import com.microservice.currencyexchange.beans.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange,Long> {
    public CurrencyExchange findByFromAndTo(String from, String to);
}
