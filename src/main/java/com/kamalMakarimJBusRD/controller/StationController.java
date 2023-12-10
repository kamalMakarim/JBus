package com.kamalMakarimJBusRD.controller;


import com.kamalMakarimJBusRD.City;
import com.kamalMakarimJBusRD.Station;
import com.kamalMakarimJBusRD.dbjson.JsonAutowired;
import com.kamalMakarimJBusRD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController implements BasicGetController<Station> {
    public static @JsonAutowired(value = Station.class, filepath = "src\\main\\java\\com\\kamalMakarimJBusRD\\json\\station.json") JsonTable<Station> stationTable;
    @Override
    public JsonTable<Station> getJsonTable() {
        return stationTable;
    }

    //Add new Station
    @PostMapping("/create")
    public BaseResponse<Station> createStation(
            @RequestParam String stationName,
            @RequestParam String city,
            @RequestParam String address
    ) {
        try {
            // Validate parameters
            if (stationName.isBlank() || city.isBlank() || address.isBlank()) {
                return new BaseResponse<>(false, "Parameter values cannot be blank or null", null);
            }
            City cityEnum = City.valueOf(city.toUpperCase());
            Station newStation = new Station(stationName, cityEnum, address);
            stationTable.add(newStation);
            return new BaseResponse<>(true, "Station added successfully", newStation);
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(false, "Invalid city value", null);
        } catch (Exception e) {
            return new BaseResponse<>(false, "An error occurred while adding the station", null);
        }
    }

    @GetMapping("/getAll")
    public List<Station> getAllStation() { return getJsonTable();}

}
