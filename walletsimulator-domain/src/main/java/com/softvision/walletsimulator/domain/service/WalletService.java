package com.softvision.walletsimulator.domain.service;

import com.softvision.walletsimulator.api.model.Transference;
import com.softvision.walletsimulator.api.model.Wallet;
import com.softvision.walletsimulator.domain.exception.WalletNotFoundException;
import com.softvision.walletsimulator.domain.exception.utils.ExceptionCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class WalletService {
    private LinkedHashMap<Integer, Wallet> wallets;
    private CurrencyService currencyService;

    @Autowired
    public WalletService(CurrencyService currencyService){
        this.currencyService = currencyService;
        this.wallets = new LinkedHashMap<>();
    }

    public Wallet createWallet(String name, LinkedHashMap<String,Double> initialValues) {
        Wallet wallet = new Wallet(name, initialValues);
        wallets.put(wallet.getId(), wallet);
        return wallet;
    }

    public Wallet getWalletById(Integer id) {
        validateExistingWalletId(id);
        return wallets.get(id);
    }

    public Wallet updateWallet(Integer walletId, Wallet wallet) {
        validateExistingWalletId(walletId);
        Wallet updatedWallet = wallets.get(walletId);
        updatedWallet.setName(wallet.getName());
        updatedWallet.setAvailable(wallet.getAvailable());
        return wallets.replace(walletId, updatedWallet);
    }

    public Wallet removeWallet(Integer id) {
        validateExistingWalletId(id);
        return wallets.remove(id);
    }

    public void transfer(Transference transference) {
        validateExistingWalletId(transference.getOriginWalletId());
        validateExistingWalletId(transference.getDestinationWalletId());

    }


    protected Map<Integer,Wallet> getWallets() {
        return wallets;
    }

    private void validateExistingWalletId(Integer id) {
        if (!wallets.containsKey(id)) {
            throw new WalletNotFoundException(ExceptionCodes.WALLET_NOT_FOUND, id.toString());
        }
    }

    //private Double getConversion() {

    //}
}
