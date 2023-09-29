package kamalMakarimJBusRD;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Invoice extends Serializable
{
    public Calendar time;
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

    
    public Invoice(int id, int buyerId, int renterId){
        super(id);
        this.time = Calendar.getInstance();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = BusRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(int id, Account buyer, Renter renter){
        super(id);
        this.time = Calendar.getInstance();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = BusRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
    return "\nInvoiceId: " + id + "\nTime: " + sdf.format(time.getTime()) + "\nbuyerId: " + buyerId + "\nrenterId: " + renterId + "\nrating: " + rating + "\nstatus: " + status;
    }

}
