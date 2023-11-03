package kamalMakarimJBusRD;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents a renter
 */
public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public String address;
    public String companyName;
    public int phoneNumber;
    private final String REGEX_PHONE = "^\\d{9,12}$";
    private final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{3,19}$";
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

    public boolean validate(){
        Pattern phonePattern = Pattern.compile(REGEX_PHONE);
        Pattern namePattern = Pattern.compile(REGEX_NAME);
        Matcher phoneMatcher = phonePattern.matcher(String.valueOf(phoneNumber));
        Matcher nameMatcher = namePattern.matcher(companyName);
        return phoneMatcher.find() && nameMatcher.find();
    }
}
