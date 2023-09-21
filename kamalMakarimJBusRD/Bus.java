package kamalMakarimJBusRD;


public class Bus extends Serializable
{
    // instance variables - replace the example below with your own
    public int capacity;
    public Facility facility;
    public String name;
    public Price price;
    
    public Bus(int id, String name, Facility facility, Price price, int capacity)
    {
        super(id);
        this.capacity = capacity;
        this.facility = facility;
        this.price = price;
        this.name = name;
    }
}
