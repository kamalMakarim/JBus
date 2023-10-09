package kamalMakarimJBusRD;

public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public String address;
    public String companyName;
    public int phoneNumber;
    
    public Renter(String companyName){
        super();
        this.address = "";
        this.companyName = companyName;
        this.phoneNumber = 0;
    }
    
    public Renter(String companyName, String address){
        super();
        this.address = address;
        this.companyName = companyName;
        this.phoneNumber = 0;
    }
    
    public Renter(String companyName, int phoneNumber){
        super();
        this.address = "";
        this.companyName = companyName;
        this.phoneNumber = 0;
    }
    
    public Renter(String companyName, int phoneNumber, String address){
        super();
        this.address = address;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
    }
}
