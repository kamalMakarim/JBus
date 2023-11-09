package com.kamalMakarimJBusRD;
import java.util.ArrayList;


public class Validate
{
    public Validate(){
    }

    /**
     * To return a list of price that less than or above the given value
     * @param list The list of prices that is checked
     * @param value The value for filtering
     * @param less The true if the mode is less than, false if the mode is above
     * @return The filtered array of prices
     */
    public static ArrayList<Price> filter(Price[] list, int value, boolean less){
        ArrayList<Price> filterList = new ArrayList<Price>();
        for(Price price : list){
            if(less && price.price < value){
                filterList.add(price);
            }
            
            if(!less && price.price > value){
                filterList.add(price);
            }
        }
        return filterList;
    }
}
