package com.kamalMakarimJBusRD;

/**
 * Represents the price of something
 */
public class Price
{
    // instance variables - replace the example below with your own
    public double price;
    public int discount;
    public double rebate;

    /**
     * Construct price with the given specification
     * discount = 0, rebate = 0
     * @param price The price
     */
    public Price(double price){
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }

    /**
     * Construct price with the given specification
     * rebate = 0
     * @param price The price variable
     * @param discount The discount variable
     */
    public Price(double price, int discount){
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }

    /**
     * Construct price with the given specification
     * discount = 0
     * @param price The price variable
     * @param rebate The rebate variable
     */
    public Price(double price, double rebate){
        this.price = price;
        this.discount = 0;
        this.rebate = rebate;
    }

    /**
     * Get price after being discounted
     * @return Discounted price
     */
    private double getDiscountedPrice(){
        if(this.discount >= 100){
            return 0.0;
        }
        else{
            return (price * (1.0 - (discount / 100.0)));
        }
    }

    /**
     * Get price after being rebated
     * @return Rebated price
     */
    private double getRebatedPrice(){
        if(this.rebate >= this.price){
            return 0;
        }
        
        else{
            return this.price-this.rebate;
        }
    }

    /**
     * Convert all data in the price object to String
     * @return All data of the price object in String
     */
    public String toString (){
        return "price: " + price + "\tdiscount: " + discount + "\trebate: " + rebate;
    }
}
