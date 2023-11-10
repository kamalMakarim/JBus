package com.kamalMakarimJBusRD.controller;

import com.kamalMakarimJBusRD.Account;
import com.kamalMakarimJBusRD.Algorithm;
import com.kamalMakarimJBusRD.Predicate;
import com.kamalMakarimJBusRD.Renter;
import com.kamalMakarimJBusRD.dbjson.JsonAutowired;
import com.kamalMakarimJBusRD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.apache.logging.log4j.util.Strings.isBlank;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{

    public static @JsonAutowired(value = Account.class, filepath = "src\\main\\java\\com\\kamalMakarimJBusRD\\json\\account.json")
    JsonTable<Account> accountTable;
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
    public AccountController() {}

    @PostMapping("/register")
    BaseResponse<Account> register (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password){

        Account account = new Account(name, email, password);
        MessageDigest md = null;
        if(!account.validate()){
            return new BaseResponse<>(false, "Invalid email or password", null);
        }
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(account.password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            account.password = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Predicate<Account> p = a -> a.email.equals(account.email);
        if(Algorithm.exists(accountTable, p)){
            return new BaseResponse<>(false, "Email already used", null);
        }

        if(account.validate() && !isBlank(name)){
            accountTable.add(account);
            return new BaseResponse<>(true, "Account created", account);
        }

        return  new BaseResponse<>(false, "Invalid inputs", null);
    }

    @PostMapping("/{id}/topUp")
    BaseResponse<Double> topUp (
            @PathVariable int id,
            @RequestParam double amount){
        Predicate<Account> p = t -> t.id == id;
        Account account = Algorithm.find(accountTable, p);
        if(account == null) {
            return new BaseResponse<>(false, "Account not found", null);
        }
        if(!account.topUp(amount)){
            return new BaseResponse<>(false, "Amount cannot be negative", account.balance);
        }
        return new BaseResponse<>(true, "Top up success", account.balance);
    }

    @PostMapping("/login")
    BaseResponse<Account> login (
            @RequestParam String email,
            @RequestParam String password){
        MessageDigest md = null;
        String temp = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            temp = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        String hashedPassword = temp;
        Predicate <Account> p = t -> t.email.equals(email) && t.password.equals(hashedPassword);
        Account account = Algorithm.find(accountTable, p);
        if(account != null)
            return new BaseResponse<>(true, "Login success", account);
        return new BaseResponse<>(false, "Invalid email or password", null);
    }

    @PostMapping("/{id}/registerRenter")
    BaseResponse<Renter> registerRenter(
            @PathVariable int id,
            @RequestParam String companyName,
            @RequestParam String address,
            @RequestParam String PhoneNumber) {
        Predicate<Account> p = t -> t.id == id;
        Account account = Algorithm.find(accountTable, p);
        if (account != null) {
            if (account.company != null)
                return new BaseResponse<>(false, "Renter already registered", null);
            Renter renter = new Renter(companyName, address, PhoneNumber);
            if (!renter.validate())
                return new BaseResponse<>(false, "Invalid renter inputs", null);
            account.company = renter;
            return new BaseResponse<>(true, "Renter created", renter);
        }
        return new BaseResponse<>(false, "Account not found", null);
    }

}
