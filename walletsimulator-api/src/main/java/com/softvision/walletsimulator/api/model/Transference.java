package com.softvision.walletsimulator.api.model;

public class Transference {

    private Integer originWalletId;
    private String originCurrency;
    private Integer originAmount;
    private Integer destinationWalletId;
    private String destinationCurrency;
    private String destinationAmount;

    public Transference() {

    }

    public Integer getOriginWalletId() {
        return originWalletId;
    }

    public void setOriginWalletId(Integer originWalletId) {
        this.originWalletId = originWalletId;
    }

    public String getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(String originCurrency) {
        this.originCurrency = originCurrency;
    }

    public Integer getOriginAmount() {
        return originAmount;
    }

    public void setOriginAmount(Integer originAmount) {
        this.originAmount = originAmount;
    }

    public Integer getDestinationWalletId() {
        return destinationWalletId;
    }

    public void setDestinationWalletId(Integer destinationWalletId) {
        this.destinationWalletId = destinationWalletId;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public String getDestinationAmount() {
        return destinationAmount;
    }

    public void setDestinationAmount(String destinationAmount) {
        this.destinationAmount = destinationAmount;
    }
}
