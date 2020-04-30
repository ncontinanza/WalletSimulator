package com.softvision.walletsimulator.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrenciesResponse {
    private String message;
    private int type;
    private Map<Integer,CurrencyInfo> data;

    public CurrenciesResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Map<Integer, CurrencyInfo> getData() {
        return data;
    }

    public void setData(Map<Integer, CurrencyInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CurrenciesResponse{" +
                "message='" + message + '\'' +
                ", type=" + type +
                ", data=" + data +
                '}';
    }
}
