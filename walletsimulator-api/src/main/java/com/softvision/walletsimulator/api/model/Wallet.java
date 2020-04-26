package com.softvision.walletsimulator.api.model;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Wallet {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);

    private Integer id;
    private String name;
    private LinkedHashMap<String, Double> available;

    public Wallet() { }

    public Wallet(String name) {
        this(ID_GENERATOR.getAndIncrement(), name, new LinkedHashMap<>());
    }

    public Wallet(String name, LinkedHashMap<String,Double> initialValues) {
        this(ID_GENERATOR.getAndIncrement(), name, initialValues);
    }

    public Wallet(Integer id, String name, LinkedHashMap<String,Double> initialValues) {
        this.id = id;
        this.name = name;
        this.available = initialValues;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedHashMap<String, Double> getAvailable() {
        return available;
    }

    public void setAvailable(LinkedHashMap<String, Double> available) {
        this.available = available;
    }
}
