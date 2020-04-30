package com.softvision.walletsimulator.domain.client;

import com.softvision.walletsimulator.domain.connector.WalletSimulatorRestConnector;
import com.softvision.walletsimulator.domain.model.CurrenciesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CurrencyClient {
    private WalletSimulatorRestConnector restConnector;
    private final String currencyUrl = "https://min-api.cryptocompare.com/data/top/totaltoptiervol?limit=100&tsym=USD";

    @Autowired
    public CurrencyClient(WalletSimulatorRestConnector restConnector) {
        this.restConnector = restConnector;
    }

    public Map<String, Double> getCurrencies() {
        Map<String,Object> response = restConnector.get(currencyUrl, Map.class);
        Map<String, Object> map = (Map<String, Object>) response.get("Data");

        //map.get("ConversionInfo").get()

        return new LinkedHashMap<String,Double>();
    }
}
