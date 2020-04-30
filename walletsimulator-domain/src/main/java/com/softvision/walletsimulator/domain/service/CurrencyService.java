package com.softvision.walletsimulator.domain.service;

import com.softvision.walletsimulator.domain.client.CurrencyClient;
import com.softvision.walletsimulator.domain.model.CurrenciesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CurrencyService {
    private CurrencyClient currencyClient;

    @Autowired
    public CurrencyService(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    public Map<String,Double> getCurrencies() {
        return currencyClient.getCurrencies();
    }


}
