package com.softvision.walletsimulator.controller;

import com.softvision.walletsimulator.domain.service.CurrencyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/currency")
@Api(value = "/currency", tags = { "Currency" })
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Double>> getAllCurrencies() {
        return ResponseEntity.ok(currencyService.getCurrencies());
    }
}
