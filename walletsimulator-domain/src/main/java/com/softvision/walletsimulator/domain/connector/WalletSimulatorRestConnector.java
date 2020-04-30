package com.softvision.walletsimulator.domain.connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WalletSimulatorRestConnector {
    private RestTemplate restTemplate;

    @Autowired
    public WalletSimulatorRestConnector(ObjectMapper mapper) { initRestTemplate(mapper); }

    private void initRestTemplate(ObjectMapper mapper) {
        this.restTemplate = new RestTemplate(/*new HttpComponentsClientHttpRequestFactory()*/);
        this.restTemplate.getMessageConverters().clear();
        this.restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter(mapper));
    }

    public <T> T get(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);
    }

}
