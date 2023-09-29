package kamalMakarimJBusRD;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class Payment extends Invoice
{
    private int busId;
    public Calendar departureDate;
    public String busSeat;
    
    public Payment(int id, int buyerId, int renterId, int busId, String busSeat){
        super(id, buyerId, renterId);
        this.busId = busId;
        this.departureDate = departureDate;
        this. busSeat = busSeat;
    }
    
    public Payment(int id, Account buyer, Renter renter, int busId, String busSeat){
        super(id, buyer.id, renter.id);
        this.busId = busId;
        this.departureDate = Calendar.getInstance();
        this. busSeat = busSeat;
        departureDate.add(Calendar.DAY_OF_MONTH, 2);
    }
    
    public String getDepartureTime(){
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
}
