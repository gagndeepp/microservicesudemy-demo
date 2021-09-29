package com.microservice.currencyexchange.controller;

import com.microservice.currencyexchange.beans.CurrencyExchange;
import com.microservice.currencyexchange.repo.CurrencyExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class Controller {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to) {

        CurrencyExchange ce = currencyExchangeRepo.findByFromAndTo(from, to);
        ce.setEnvironment(environment.getProperty("local.server.port"));
        return ce;
    }

}
