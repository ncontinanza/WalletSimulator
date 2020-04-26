package com.softvision.walletsimulator.api.model;

import java.util.LinkedHashMap;

public class Wallet {
    private Integer id;
    private String name;
    private LinkedHashMap<String, Double> available;

    public Wallet(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.available = new LinkedHashMap<>();
    }

    public Integer getId() {
        return id;
    }
}
