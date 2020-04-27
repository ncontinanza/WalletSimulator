package com.softvision.walletsimulator.domain.service;

import com.softvision.walletsimulator.api.model.Wallet;
import com.softvision.walletsimulator.domain.exception.WalletNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedHashMap;

import static java.lang.String.format;

public class WalletServiceTest {

    private WalletService walletService;
    private static final String walletName = "wallet";

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setUp() {
        this.walletService = new WalletService();
    }

    @Test
    public void createWalletWithNameTest() {
        Wallet wallet = walletService.createWallet(walletName, new LinkedHashMap<>());
        Assert.assertEquals(walletName, wallet.getName());
        Assert.assertTrue(wallet.getAvailable().isEmpty());
    }

    @Test
    public void createWalletWithNameAndInitialValuesTest() {
        LinkedHashMap<String,Double> initialAvailable = new LinkedHashMap<>();
        initialAvailable.put("BTC", 123.456D);
        initialAvailable.put("ETH", 234.567D);

        Wallet wallet = walletService.createWallet(walletName, initialAvailable);
        Assert.assertEquals(walletName, wallet.getName());
        Assert.assertEquals(initialAvailable, wallet.getAvailable());
    }

    @Test
    public void getWalletByIdTest(){
        Wallet wallet = walletService.createWallet(walletName, null);
        Assert.assertEquals(wallet, walletService.getWalletById(wallet.getId()));
    }

    @Test
    public void getWalletWithInvalidIdThrowsExceptionTest(){
        Integer walletId = 1;

        thrown.expect(WalletNotFoundException.class);
        thrown.expectMessage(format("Wallet with id %s not found", walletId.toString()));

        walletService.getWalletById(walletId);
    }

    @Test
    public void updateWalletTest() {
        LinkedHashMap<String,Double> initialAvailable = new LinkedHashMap<>();
        initialAvailable.put("BTC", 123.456D);
        initialAvailable.put("ETH", 234.567D);

        Wallet wallet = walletService.createWallet(walletName, initialAvailable);
        wallet.setAvailable(null);
        Wallet updatedWallet = walletService.updateWallet(wallet.getId(), wallet);
        Assert.assertNull(updatedWallet.getAvailable());
    }

    @Test
    public void updateWalletWithInvalidIdThrowsExceptionTest() {
        Integer invalidWalletId = 1;
        Wallet wallet = walletService.createWallet(walletName, null);

        thrown.expect(WalletNotFoundException.class);
        thrown.expectMessage(format("Wallet with id %s not found", invalidWalletId.toString()));

        walletService.updateWallet(invalidWalletId, wallet);
    }

    @Test
    public void removeWalletTest() {
        Wallet wallet = walletService.createWallet(walletName, null);
        Wallet removedWallet = walletService.removeWallet(wallet.getId());
        Assert.assertEquals(removedWallet, wallet);

        thrown.expect(WalletNotFoundException.class);
        thrown.expectMessage(format("Wallet with id %s not found", wallet.getId().toString()));
        walletService.getWalletById(wallet.getId());
    }

    @Test
    public void removeWalletWithInvalidIdThrowsExceptionTest() {
        Integer walletId = 1;
        thrown.expect(WalletNotFoundException.class);
        thrown.expectMessage(format("Wallet with id %s not found", walletId.toString()));
        walletService.getWalletById(walletId);
    }
}
