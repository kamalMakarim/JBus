package com.kamalMakarimJBusRD;

import com.kamalMakarimJBusRD.dbjson.Serializable;

/**
 * Represents the voucher in a bus system
 */
public abstract class Voucher extends Serializable
{
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;

    /**
     * Constructing the Voucher object with the given specification
     * @param name The name of the voucher
     * @param code The code of the voucher
     * @param type The type of the voucher
     * @param minimum The minimum price to use the voucher
     * @param cut The amount of cut from the voucher
     */
    public Voucher(String name,int code , Type type, double minimum, double cut){
        super();
        this.name = name;
        this.used = false;
        this.minimum = minimum;
        this.cut = cut;
        this.code = code;
        this.type = type;
    }

    /**
     * To find the price after a voucher
     * @param price The price where the voucher is applied
     * @return The price after a cut (if there is any)
     */
    public double apply(Price price){
        
        if(!canApply(price)){
            return price.price;
        }
        this.used = true;
        
        if(type == Type.DISCOUNT){    
            if(price.price <= price.rebate){
                this.cut = 100;
            }
            
            else{
                this.cut = (price.rebate * 100) / price.price;
            }
            return price.price - (price.price * (cut * 0.01));
        }
        

        this.cut = price.rebate;
        return price.price - cut;
    }

    /**
     * To check if the voucher is used or not
     * @return True if the voucher is used
     */
    public boolean isUsed(){
        return used;
    }

    /**
     * To check if the voucher could be applied on the price object
     * @param price The price that is checked
     * @return Return true if the price is appliable
     */
    public boolean canApply(Price price){
        return price.price > minimum && !used;
    }
    
}


