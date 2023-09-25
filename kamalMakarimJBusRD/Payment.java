package kamalMakarimJBusRD;

public class Payment extends Invoice
{
    private int busId;
    public String departureDate;
    public String busSeat;
    
    public Payment(int id, int buyerId, int renterId, String time, int busId, String departureDate, String busSeat){
        super(id, buyerId, renterId, time);
        this.busId = busId;
        this.departureDate = departureDate;
        this. busSeat = busSeat;
    }
    
    public Payment(int id, Account buyer, Renter renter, String time, int busId, String departureDate, String busSeat){
        super(id, buyer.id, renter.id, time);
        this.busId = busId;
        this.departureDate = departureDate;
        this. busSeat = busSeat;
    }
    
    public String toString(){
        return "\nPaymentId: " + id + "\nTime: " + time + "\nbuyerId: " + buyerId + "\nrenterId" + renterId + "\nbusId" + busId + "\ndepartureTime: " + departureDate + "\nbusSeat+ " + busSeat;
    }
    
    public int getBusId(){
        return busId;
    }
}
