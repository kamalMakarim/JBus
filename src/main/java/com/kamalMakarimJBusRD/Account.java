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


    /**
     * Constructor for objects of class Account
     * @param name name of the account
     * @param email email of the account
     * @param password password of the account
     */
    public Account (String name, String email, String password){
        super();
        this.name = name;
        this.email= email;
        this.password = password;
        this.balance = 0;
        this.company = null;
    }

    /**
     * Convert the object to string
     * @return string representation of the object
     */
    public String toString(){
        return "AccountId: " + id + "\temail: " + email + "\tname: " + name + "\tpassword: " + password;
    }

    /**
     * Add company to the account
     * @param amount amount of money to be added
     */
    public boolean topUp(double amount){
        if(amount > 0){
            this.balance += amount;
            return true;
        }
        return false;
    }

    /**
     * validate the account email and password
     * @return true if the email and password is valid
     */
    public boolean validate(){
        return this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD);
    }
}