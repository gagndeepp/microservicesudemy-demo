package com.microservice.currencyconversion.proxy;

import com.microservice.currencyconversion.beans.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name="currency-exchange",url="http://localhost:8001")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getCurrencyExchange(@PathVariable String from, @PathVariable String to);

}
