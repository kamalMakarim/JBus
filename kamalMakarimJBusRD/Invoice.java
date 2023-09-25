package kamalMakarimJBusRD;

public class Invoice extends Serializable
{
    public String time;
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

    
    public Invoice(int id, int buyerId, int renterId, String time){
        super(id);
        this.time = time;
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = BusRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(int id, Account buyer, Renter renter, String time){
        super(id);
        this.time = time;
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = BusRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String toString(){
        return "\nInvoiceId: " + id + "\nTime: " + time + "\nbuyerId: " + buyerId + "\nrenterId: " + renterId + "\nrating: " + rating + "\nstatus: " + status;
    }
    
}
