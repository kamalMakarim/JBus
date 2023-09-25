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
        return "PaymentId: " + id + "\tTime: " + time + "\tbuyerId: " + buyerId + "\trenterId" + renterId + "\tbusId" + busId + "\tdepartureTime: " + departureDate + "\tbusSeat+ " + busSeat;
    }
    
    public int getBusId(){
        return busId;
    }
}
