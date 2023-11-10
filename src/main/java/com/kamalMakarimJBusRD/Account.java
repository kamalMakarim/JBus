package com.kamalMakarimJBusRD;


import com.kamalMakarimJBusRD.dbjson.Serializable;

public class Account extends Serializable
{
    public String email;
    public String name;
    public String password;
    public Renter company;
    public double balance;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z_]+?\\.[a-zA-Z.]+[a-zA-Z]+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";



    public Account (String name, String email, String password){
        super();
        this.name = name;
        this.email= email;
        this.password = password;
        this.balance = 0;
        this.company = null;
    }
    
    public String toString(){
        return "AccountId: " + id + "\temail: " + email + "\tname: " + name + "\tpassword: " + password;
    }

    public boolean topUp(double amount){
        if(amount > 0){
            this.balance += amount;
            return true;
        }
        return false;
    }
    public boolean validate(){
        return this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD);
    }
}