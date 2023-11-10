package com.kamalMakarimJBusRD.controller;

import com.kamalMakarimJBusRD.Account;
import com.kamalMakarimJBusRD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static JsonTable<Account> accountTable;
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return new Account(name, email, password);
    }

}
