package kamalMakarimJBusRD;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.sql.Timestamp;

public class Bus extends Serializable implements FileParser
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
    public List<Schedule> schedules;
    
    @Override
    public Object write() {
        return null; 
    }

    @Override
    public boolean read(String string) {
        return false;
    }
    
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
        this.schedules = new ArrayList();
    }
    
    public String toString(){
        return "\nbusId: " + id + "\ncapacity: " + capacity + "\nfacility: " + facility + "\nname: " + name + price + "\nbusType: " + busType + "\ncity: " + city + "\nDeparture: " + departure + "\nArrival" + arrival;
    }
    
    public void addSchedule(Timestamp schedule) { 
        schedules.add(new Schedule(schedule, this.capacity));
    }   
}

