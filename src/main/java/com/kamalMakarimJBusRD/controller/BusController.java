package com.kamalMakarimJBusRD.controller;

import com.kamalMakarimJBusRD.*;
import com.kamalMakarimJBusRD.dbjson.JsonAutowired;
import com.kamalMakarimJBusRD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController implements BasicGetController<Bus>{
    public static @JsonAutowired(value = Bus.class, filepath = "src\\main\\java\\com\\kamalMakarimJBusRD\\json\\bus.json") JsonTable<Bus> busTable;

    public BusController(){}

    @PostMapping("/addSchedule")
    public BaseResponse<Bus> addSchedule(
            @RequestParam int busId,
            @RequestParam String time){
        Predicate<Bus> p = b -> b.id == busId;
        if(!Algorithm.exists(busTable, p)){
            return new BaseResponse<>(false, "Bus not found", null);
        }
        Bus bus = Algorithm.find(busTable, p);
        Timestamp scheduleTime;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            scheduleTime = Timestamp.valueOf(LocalDateTime.parse(time, formatter));
        } catch (DateTimeParseException e) {
            return new BaseResponse<>(false, "Invalid time format", null);
        }
        bus.addSchedule(scheduleTime);
        return new BaseResponse<>(true, "Schedule added", bus);
    }

    public JsonTable<Bus> getJsonTable(){
        return busTable;
    }

    @PostMapping("/create")
    public BaseResponse<Bus> create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int capacity,
            @RequestParam List<Facility> facilities,
            @RequestParam BusType busType,
            @RequestParam int price,
            @RequestParam int stationDepartureId,
            @RequestParam int stationArrivalId){
        Predicate<Account> p = a -> a.id == accountId;
        Account account = Algorithm.find(AccountController.accountTable, p);
        if(account == null){
            return new BaseResponse<>(false, "Account not found", null);
        }

        if(account.company == null){
            return new BaseResponse<>(false, "Account has no company", null);
        }

        Predicate<Station> p1 = s -> s.id == stationDepartureId;
        Predicate<Station> p2 = s -> s.id == stationArrivalId;
        if(Algorithm.exists(StationController.stationTable, p1) && Algorithm.exists(StationController.stationTable, p2)){
            Station stationDeparture = Algorithm.find(StationController.stationTable, p1);
            Station stationArrival = Algorithm.find(StationController.stationTable, p2);
            Bus bus = new Bus(accountId, name, facilities, new Price(price), capacity, busType, stationDeparture, stationArrival);
            bus.account = account;
            busTable.add(bus);
            return new BaseResponse<>(true, "Bus created", bus);
        }
        return new BaseResponse<>(false, "Station not found", null);
    }
}
