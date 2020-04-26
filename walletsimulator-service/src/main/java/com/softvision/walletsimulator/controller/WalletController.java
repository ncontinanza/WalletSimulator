package com.softvision.walletsimulator.controller;

import com.softvision.walletsimulator.api.model.Wallet;
import com.softvision.walletsimulator.domain.service.WalletService;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wallet")
public class WalletController {
    private MapperFactory mapperFactory;
    private WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService){
        this.walletService = walletService;
        this.mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
    }

    @PostMapping(path="/{walletName}")
    public ResponseEntity<Wallet> createWallet(@PathVariable String name, @RequestBody(required = false) Wallet wallet) {
        com.softvision.walletsimulator.domain.model.Wallet domainWallet = mapperFactory.getMapperFacade().map(wallet, com.softvision.walletsimulator.domain.model.Wallet.class);
        com.softvision.walletsimulator.domain.model.Wallet responseWallet = walletService.createWallet(name, domainWallet);
        return ResponseEntity.ok(mapperFactory.getMapperFacade().map(responseWallet, Wallet.class));
    }

    @GetMapping(path="/{walletName}")
    public ResponseEntity<Wallet> getWallet(@PathVariable Integer id) {
        // TODO: try to make id a Long variable.
        Wallet responseWallet = mapperFactory.getMapperFacade().map(walletService.getWalletById(id), Wallet.class);
        return ResponseEntity.ok(responseWallet);
    }

    @PutMapping
    public ResponseEntity<Wallet> updateWallet(@PathVariable Wallet wallet) {
        com.softvision.walletsimulator.domain.model.Wallet domainWallet = mapperFactory.getMapperFacade().map(wallet, com.softvision.walletsimulator.domain.model.Wallet.class);
        com.softvision.walletsimulator.domain.model.Wallet responseWallet = walletService.updateWallet(domainWallet);
        return ResponseEntity.ok(mapperFactory.getMapperFacade().map(responseWallet, Wallet.class));
    }

    @DeleteMapping
    public ResponseEntity<Wallet> removeWallet(@PathVariable Integer id) {
        Wallet responseWallet = mapperFactory.getMapperFacade().map(walletService.removeWallet(id), Wallet.class);
        return ResponseEntity.ok(responseWallet);
    }
}
