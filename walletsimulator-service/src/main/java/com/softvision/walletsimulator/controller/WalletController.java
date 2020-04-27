package com.softvision.walletsimulator.controller;

import com.softvision.walletsimulator.api.model.Wallet;
import com.softvision.walletsimulator.domain.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Optional;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    private WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }

    @PostMapping(value="/{walletName}")
    public ResponseEntity<Wallet> createWallet(@PathVariable String walletName, @RequestBody(required = false) LinkedHashMap<String,Double> initialValues) {
        LinkedHashMap<String,Double> available = Optional.ofNullable(initialValues).orElse(new LinkedHashMap<>());
        return ResponseEntity.ok(walletService.createWallet(walletName, available));
    }

    @GetMapping(value="/{walletId}")
    public ResponseEntity<Wallet> getWallet(@PathVariable Integer walletId) {
        // TODO: try to make id a Long variable.
        return ResponseEntity.ok(walletService.getWalletById(walletId));
    }

    @PutMapping(value="/{walletId}")
    public ResponseEntity<Wallet> updateWallet(@PathVariable Integer walletId, @RequestBody Wallet updatedWallet) {
        return ResponseEntity.ok(walletService.updateWallet(walletId, updatedWallet));
    }

    @DeleteMapping(value="/{walletId}")
    public ResponseEntity<Wallet> removeWallet(@PathVariable Integer walletId) {
        return ResponseEntity.ok(walletService.removeWallet(walletId));
    }
}
