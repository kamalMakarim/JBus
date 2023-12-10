package com.kamalMakarimJBusRD;
import com.kamalMakarimJBusRD.dbjson.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class Bus extends Serializable
{
    public int capacity;
    public List<Facility> facilities;
    public String name;
    public Price price;
    public BusType busType;
    public Station departure;
    public Station arrival;
    public List<Schedule> schedules;
    public int accountId;
    public Object account;

    public Object write() {
        return null;
    }


    public boolean read(String string) {
        return false;
    }

    /**
     * Constructor for objects of class Bus
     * @param accountId The account id
     * @param name The bus name
     * @param facilities The list of facilities
     * @param price The price object
     * @param capacity The bus capacity
     * @param busType The bus type
     * @param departure The departure station
     * @param arrival The arrival station
     */
    public Bus(int accountId,String name, List<Facility> facilities, Price price, int capacity, BusType busType, Station departure, Station arrival)
    {
        super();
        this.accountId = accountId;
        this.capacity = capacity;
        this.facilities = facilities;
        this.price = price;
        this.name = name;
        this.busType = busType;
        this.departure = departure;
        this.arrival = arrival;
        this.schedules = new ArrayList<Schedule>();
    }

    /**
     * convert all data in the Bus object to string
     * @return All data in the Bus object in a string
     */
    public String toString(){
        return "BusId: " + id + "\tcapacity: " + capacity + "\tfacility: " + facilities + "\tname: " + name + price + "\tbusType: " + busType + "\tDeparture: " + departure + "\tArrival" + arrival;
    }

    /**
     * to add schedule to the bus
     * @param timestamp The timestamp of the new schedule
     */
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

