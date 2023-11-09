package com.kamalMakarimJBusRD;

import java.sql.Timestamp;
public class BookingThread extends Thread{
    private Bus bus;
    private Timestamp timestamp ;
    public BookingThread(String name, Bus bus, Timestamp timestamp){
        super(name);
        this.bus = bus;
        this.timestamp = timestamp;
        this.start();
    }
    public void run(){
        System.out.println(this.getName() + " ID : " + Thread.currentThread().getId() + " is running");
        synchronized (bus) {
            boolean booking = Payment.makeBooking(timestamp, "RD01", bus);
            if(booking){
                System.out.println(this.getName() + " Berhasil Melakukan Booking");
            }
            else{
                System.out.println(this.getName() + " Gagal Melakukan Booking");
            }
        }
    }
}