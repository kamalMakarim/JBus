package kamalMakarimJBusRD;

/**
 * This class represents a renter
 */
public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public String address;
    public String companyName;
    public int phoneNumber;

    /**
     * To construct the Renter object with the given specification
     * address = "", phoneNumber = 0
     * @param companyName The name of the renter company
     */
    public Renter(String companyName){
        super();
        this.address = "";
        this.companyName = companyName;
        this.phoneNumber = 0;
    }

    /**
     * To construct the Renter object with the given specification
     * phone number = 0
     * @param companyName The name of the renter company
     * @param address The address of the renter
     */
    public Renter(String companyName, String address){
        super();
        this.address = address;
        this.companyName = companyName;
        this.phoneNumber = 0;
    }

    /**
     * To construct the Renter object with the given specification
     * address = ""
     * @param companyName The name of the renter company
     * @param phoneNumber The phone number of the renter
     */
    public Renter(String companyName, int phoneNumber){
        super();
        this.address = "";
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * To construct the Renter object with the given specification
     * @param companyName The name of the renter company
     * @param phoneNumber The phone number of the renter
     * @param address The address of the renter
     */
    public Renter(String companyName, int phoneNumber, String address){
        super();
        this.address = address;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
    }
}
