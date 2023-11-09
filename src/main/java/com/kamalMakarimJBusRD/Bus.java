package com.kamalMakarimJBusRD;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.sql.Timestamp;

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
    public List<Schedule> schedules;

    public Object write() {
        return null; 
    }

    public boolean read(String string) {
        return false;
    }

    public Bus(String name, Facility facility, Price price, int capacity, BusType busType, City city, Station departure, Station arrival)
    {
        super();
        this.capacity = capacity;
        this.facility = facility;
        this.price = price;
        this.name = name;
        this.busType = busType;
        this.city = city;
        this.departure = departure;
        this.arrival = arrival;
        this.schedules = new ArrayList<Schedule>();
    }

    public String toString(){
        return "BusId: " + id + "\tcapacity: " + capacity + "\tfacility: " + facility + "\tname: " + name + price + "\tbusType: " + busType + "\tcity: " + city + "\tDeparture: " + departure + "\tArrival" + arrival;
    }

    public void addSchedule(Timestamp timestamp) {
        Predicate<Schedule> scheduleExists = schedule -> schedule.departureSchedule.equals(timestamp);

        if(Algorithm.exists(schedules.iterator(), scheduleExists)){
            System.out.println("Jadwal duplikat");
        }
        else {
            schedules.add(new Schedule(timestamp, this.capacity));
        }
    }
}

