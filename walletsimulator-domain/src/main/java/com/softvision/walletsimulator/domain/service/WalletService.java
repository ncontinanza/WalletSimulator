package com.softvision.walletsimulator.domain.service;

import com.softvision.walletsimulator.domain.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class WalletService {
    private LinkedHashMap<Integer, Wallet> wallets;

    @Autowired
    public WalletService(){
        this.wallets = new LinkedHashMap<>();
    }

    public Wallet createWallet(String name, Wallet wallet) {
        // TODO: validate input
        wallets.put(wallet.getId(), wallet);

    }

    public Wallet getWalletById(Integer id) {
        return wallets.get(id);
    }

    public Wallet updateWallet(Wallet wallet) {

    }

    public Wallet removeWallet(Integer id) {

    }
}
