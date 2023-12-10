package com.kamalMakarimJBusRD;

import com.kamalMakarimJBusRD.controller.BusController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class Payment extends Invoice
{
    private int busId;
    public Timestamp departureDate;
    public List<String> busSeats;

    /**
     * Construct Payment with the given specification
     * @param buyerId
     * @param renterId
     * @param busId
     * @param busSeats
     * @param departureDate
     */
    public Payment(int buyerId, int renterId, int busId, List<String> busSeats, Timestamp departureDate){
        super(buyerId, renterId);
        this.busId = busId;
        this.departureDate = departureDate;
        this.busSeats = busSeats;
    }

    /**
     * Construct Payment with the given specification
     * @param buyer The buyer account
     * @param renter The renter object
     * @param busId The bus id
     * @param busSeats The list of bus seats
     * @param departureDate The departure date
     */
    public Payment(Account buyer, Renter renter, int busId, List<String> busSeats, Timestamp departureDate){
        super(buyer, renter);
        this.busId = busId;
        this.busSeats = busSeats;
        this.departureDate = departureDate;
    }

    /**
     * To get the departure information
     * @return The departure information
     */
    public String getDepartureInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
        return "\nPaymentId: " + id + "\nTime: " + sdf.format(departureDate.getTime()) + "\nbuyerId: " + buyerId + "\nrenterId" + renterId + "\nbusId" + busId + "\nbusSeats: " + busSeats;
    }

    /**
     * To convert all data in the Payment object to string
     * @return All data in the Payment object in a string
     */
    public String toString(){
        return "PaymentId: " + id + "\tTime: " + departureDate + "\tbuyerId: " + buyerId + "\trenterId" + renterId + "\tbusId" + busId + "\tdepartureTime: " + departureDate + "\tbusSeats+ " + busSeats;
    }

    /**
     * To get the bus id
     * @return The bus id
     */
    public int getBusId(){
        return busId;
    }

    /**
     * To get the departure date in yyyy-MM-dd HH:mm:ss format
     * @return The departure date
     */
    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(departureDate.getTime());
    }

    /**
     * Make boooking with the given specification
     * @param departureSchedule The departure schedule
     * @param seat The seat
     * @param bus The bus
     * @return true if the booking is successful
     */
    public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus){
        for(Schedule entry : bus.schedules){
            if(entry.departureSchedule.equals(departureSchedule) && entry.isSeatAvailable(seat)){
                entry.bookSeat(seat);
                return true;
            }
        }
        return false;
    }

    /**
     * Make booking with the given specification
     * @param departureSchedule The departure schedule
     * @param seats The list of seats
     * @param bus The bus
     * @return true if the booking is successful
     */
    public static boolean makeBooking(Timestamp departureSchedule, List<String> seats, Bus bus){
        for(Schedule s : bus.schedules){
            if (s.isSeatAvailable(seats) && s.departureSchedule.equals(departureSchedule)) {
                s.bookSeat(seats);
                return true;
            }
        }
        return false;
    }

    /**
     * Get the available schedule with the given specification
     * @param departureDate The departure date
     * @param seat The seat
     * @param bus The bus
     * @return The available schedule
     */
    public static Schedule availableSchedule(Timestamp departureDate, String seat, Bus bus) {
        Predicate<Schedule> predicate = sched -> departureDate.equals(sched.departureSchedule) && sched.isSeatAvailable(seat);
        return Algorithm.find(bus.schedules, predicate);
    }

    /**
     * Get the available schedule with the given specification
     * @param departureDate The departure date
     * @param busSeatList The list of bus seats
     * @param bus The bus
     * @return The available schedule
     */
    public static Schedule availableSchedule(Timestamp departureDate, List<String> busSeatList, Bus bus) {
        Predicate<Schedule> predicate = sched -> departureDate.equals(sched.departureSchedule) && sched.isSeatAvailable(busSeatList);
        return Algorithm.find(bus.schedules, predicate);
    }

    /**
     * Get the bus object
     * @return The bus object
     */
    public Bus getBus(){
        Predicate<Bus> predicate = bus -> bus.id == busId;
        return Algorithm.find(BusController.busTable, predicate);
    }
}
