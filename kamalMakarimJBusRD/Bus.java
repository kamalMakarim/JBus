package kamalMakarimJBusRD;


public class Bus extends Serializable
{
    // instance variables - replace the example below with your own
    public int capacity;
    public Facility facility;
    public String name;
    public Price price;
    public BusType busType;
    public City city;
    public Station departure;
    public Station arrival;
    
    public Bus(int id, String name, Facility facility, Price price, int capacity, BusType busType, City city, Station departure, Station arrival)
    {
        super(id);
        this.capacity = capacity;
        this.facility = facility;
        this.price = price;
        this.name = name;
        this.busType = busType;
        this.city = city;
        this.departure = departure;
        this.arrival = arrival;
    }
    
    public String toString(){
        return "busId: " + id + "\tcapacity: " + capacity + "\tfacility: " + facility + "\tname: " + name + "\tprice: " + price + "\tbusType: " + busType + "\tcity: " + city + "\tdeparture: " + departure.toString() + "\tarrival" + arrival.toString();
    }
}
