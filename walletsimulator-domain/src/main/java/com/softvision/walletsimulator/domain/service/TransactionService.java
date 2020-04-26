package com.softvision.walletsimulator.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private WalletService walletService;

    @Autowired
    public TransactionService(WalletService walletService) {
        this.walletService = walletService;
    }
}
