package kamalMakarimJBusRD;


public class Bus
{
    // instance variables - replace the example below with your own
    public int capacity;
    public Facility facility;
    public String name;
    public Price price;
    
    public Bus(String name, Facility facility, Price price, int capacity)
    {
        this.capacity = capacity;
        this.facility = facility;
        this.price = price;
        this.name = name;
    }
}
