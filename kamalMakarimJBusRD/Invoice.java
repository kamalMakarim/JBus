package kamalMakarimJBusRD;

public class Invoice extends Serializable
{
    public String time;
    public int buyerId;
    public int renterId;
    
    public Invoice(int id, int buyerId, int renterId, String time){
        super(id);
        this.time = time;
        this.buyerId = buyerId;
        this.renterId = renterId;
    }
    
    public Invoice(int id, Account buyer, Renter renter, String time){
        super(id);
        this.time = time;
        this.buyerId = buyer.id;
        this.renterId = renter.id;
    }
    
    public String print(){
        return "InvoiceId: " + id + "\tTime: " + time + "\tbuyerId: " + buyerId + "\trenterId: " + renterId;
    }
    
}
