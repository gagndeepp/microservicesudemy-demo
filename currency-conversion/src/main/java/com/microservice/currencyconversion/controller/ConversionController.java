package com.microservice.currencyconversion.controller;

import com.microservice.currencyconversion.beans.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;

@RestController
public class ConversionController {

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        HashMap<String, String> uriVars = new HashMap<>();
        uriVars.put("from",from);
        uriVars.put("to",to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class,uriVars);

        CurrencyConversion currencyConvesion = responseEntity.getBody();
        currencyConvesion.setQuantity(quantity);
        currencyConvesion.setCalculatedValue(quantity.multiply(currencyConvesion.getConversionMultiple()));

        return currencyConvesion;


    }

}
