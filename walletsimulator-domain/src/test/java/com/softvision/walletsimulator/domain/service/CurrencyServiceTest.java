package com.softvision.walletsimulator.domain.service;

import com.softvision.walletsimulator.domain.client.CurrencyClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrencyServiceTest {

    private CurrencyService currencyService;
    private CurrencyClient currencyClient;

    @Before
    public void setUp() {
        currencyClient = mock(CurrencyClient.class);
        currencyService = new CurrencyService(currencyClient);
    }

    /*@Test
    public void getCurrenciesTest() {
        LinkedHashMap<String, Double> currencies = new LinkedHashMap<>();
        currencies.put("BTC", 123.456D);
        currencies.put("ETH", 234.567D);
        when(currencyClient.getCurrencies()).thenReturn(currencies);
        Assert.assertEquals(currencies, currencyService.getCurrencies());
    }*/
}
