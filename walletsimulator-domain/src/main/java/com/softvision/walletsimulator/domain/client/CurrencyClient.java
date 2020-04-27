package com.softvision.walletsimulator.domain.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

@Component
public class CurrencyClient {
    private RestTemplate restTemplate;

    @Autowired
    public CurrencyClient() {

    }

    public LinkedHashMap<String, Double> getCurrencies() {
        return null;
    }

}
