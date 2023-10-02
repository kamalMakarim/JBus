package kamalMakarimJBusRD;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

public class Payment extends Invoice
{
    private int busId;
    public Timestamp departureDate;
    public String busSeat;
    
    public Payment(int id, int buyerId, int renterId, int busId, String busSeat, Timestamp departureDate){
        super(id, buyerId, renterId);
        this.busId = busId;
        this.departureDate = departureDate;
        this.busSeat = busSeat;
    }
    
    public Payment(int id, Account buyer, Renter renter, int busId, String busSeat, Timestamp departureDate){
        super(id, buyer, renter);
        this.busId = busId;
        this.busSeat = busSeat;
        this.departureDate = departureDate;
    }
    
    public String getDepartureInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
        return "\nPaymentId: " + id + "\nTime: " + sdf.format(departureDate.getTime()) + "\nbuyerId: " + buyerId + "\nrenterId" + renterId + "\nbusId" + busId + "\ndepartureTime: " + departureDate + "\nbusSeat+ " + busSeat;
    }
    
    public String toString(){
        return "\nPaymentId: " + id + "\nTime: " + departureDate + "\nbuyerId: " + buyerId + "\nrenterId" + renterId + "\nbusId" + busId + "\ndepartureTime: " + departureDate + "\nbusSeat+ " + busSeat;
    }
    
    public int getBusId(){
        return busId;
    }
    
    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM dd, yyyy HH:mm:ss");  
        return sdf.format(departureDate.getTime());
    }
    
    public static boolean isAvailable(Timestamp departureSchedule, String seat, Bus bus){
        for(Schedule entry : bus.schedules){
            if(entry.departureSchedule.equals(departureSchedule)){
                return entry.isSeatAvailable(seat);
            }
        }
        return false;
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
}
