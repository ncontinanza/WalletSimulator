package com.softvision.walletsimulator.domain.model;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Wallet {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);

    private Integer id;
    private String name;
    private HashMap<String, Double> available;

    public Wallet(){
        id = ID_GENERATOR.getAndIncrement();

    }

    public Integer getId() {
        return id;
    }


}
