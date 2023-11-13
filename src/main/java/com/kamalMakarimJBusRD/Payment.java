package com.kamalMakarimJBusRD;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
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
    
    public Payment(Account buyer, Renter renter, int busId, List<String> busSeats, Timestamp departureDate){
        super(buyer, renter);
        this.busId = busId;
        this.busSeats = busSeats;
        this.departureDate = departureDate;
    }
    
    public String getDepartureInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
        return "\nPaymentId: " + id + "\nTime: " + sdf.format(departureDate.getTime()) + "\nbuyerId: " + buyerId + "\nrenterId" + renterId + "\nbusId" + busId + "\nbusSeats: " + busSeats;
    }
    
    public String toString(){
        return "PaymentId: " + id + "\tTime: " + departureDate + "\tbuyerId: " + buyerId + "\trenterId" + renterId + "\tbusId" + busId + "\tdepartureTime: " + departureDate + "\tbusSeats+ " + busSeats;
    }
    
    public int getBusId(){
        return busId;
    }
    
    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM dd, yyyy HH:mm:ss");  
        return sdf.format(departureDate.getTime());
    }

    public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus){
        for(Schedule entry : bus.schedules){
            if(entry.departureSchedule.equals(departureSchedule) && entry.isSeatAvailable(seat)){
                entry.bookSeat(seat);
                return true;
            }
        }
        return false;
    }

    public static boolean makeBooking(Timestamp departureSchedule, List<String> seats, Bus bus){
        System.out.println(bus.schedules);
        for(Schedule s : bus.schedules){
            if (s.isSeatAvailable(seats) && s.departureSchedule.equals(departureSchedule)) {
                s.bookSeat(seats);
                return true;
            }
        }
        return false;
    }

    public static Schedule availableSchedule(Timestamp departureDate, String seat, Bus bus) {
        Predicate<Schedule> predicate = sched -> departureDate.equals(sched.departureSchedule) && sched.isSeatAvailable(seat);
        return Algorithm.find(bus.schedules, predicate);
    }

    public static Schedule availableSchedule(Timestamp departureDate, List<String> busSeatList, Bus bus) {
        Predicate<Schedule> predicate = sched -> departureDate.equals(sched.departureSchedule) && sched.isSeatAvailable(busSeatList);
        return Algorithm.find(bus.schedules, predicate);
    }
}
