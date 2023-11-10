package com.kamalMakarimJBusRD;
import com.kamalMakarimJBusRD.dbjson.Serializable;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;

public class Invoice extends Serializable
{
    public Timestamp time;
    public int buyerId;
    public int renterId;
    public BusRating rating;
    public PaymentStatus status;
    
    public enum BusRating{
        NONE,
        NEUTRAL,
        GOOD,
        BAD
    }
    
    public enum PaymentStatus{
        FAILED,
        WAITING,
        SUCCESS
    }

    
    protected Invoice(int buyerId, int renterId){
        super();
        this.time = new Timestamp(System.currentTimeMillis());
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = BusRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(Account buyer, Renter renter){
        super();
        this.time = new Timestamp(System.currentTimeMillis());
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = BusRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "InvoiceId: " + id + "\tTime: " + sdf.format(time.getTime()) + "\tbuyerId: " + buyerId + "\trenterId: " + renterId + "\trating: " + rating + "\tstatus: " + status;
    }

}
