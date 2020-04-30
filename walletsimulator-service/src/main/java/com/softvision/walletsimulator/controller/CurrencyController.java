package com.softvision.walletsimulator.controller;

import com.softvision.walletsimulator.domain.service.CurrencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "currency", notes = "Get all currencies with their values",
            response = Map.class)
    @GetMapping
    public ResponseEntity<Map<String, Double>> getAllCurrencies() {
        return ResponseEntity.ok(currencyService.getCurrencies());
    }
}
