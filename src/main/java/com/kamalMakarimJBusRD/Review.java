package com.kamalMakarimJBusRD;

/**
 * This class represents a review from a customer
 */
public class Review extends Serializable
{
    public String date;
    public String desc;

    /**
     * Construct a Review object with the given specification
     * @param date The date where the review is made
     * @param desc The review itself
     */
    public Review(String date, String desc){
        super();
        this.date = date;
        this.desc = desc;
    }

    /**
     * To convert all data in the Review object to string
     * @return All data in the Review object in a string
     */
    public String toString(){
        return "ReviewId: " + id +"\tDate: " + date + "\tDesc: " + desc;
    }
}
