package com.kamalMakarimJBusRD;
/**
 * This class represents the station bus
 */
public class Station extends Serializable
{
    public City city;
    public String stationName;
    public String address;

    /**
     * Construct a station object with the given specification
     * @param stationName The name of the station
     * @param city The city of the station
     * @param address The address of the station
     */
    public Station(String stationName, City city, String address){
        super();
        this.stationName = stationName;
        this.city = city;
        this.address = address;
    }

    /**
     * To convert all data in the Station object to string
     * @return all data in the Station object in a string
     */
    public String toString(){
        return "StationId: " + id + "\tCity: " + city + "\tStation Name: " + stationName;
    }
}
