package com.kamalMakarimJBusRD.controller;

import com.kamalMakarimJBusRD.*;
import com.kamalMakarimJBusRD.dbjson.JsonAutowired;
import com.kamalMakarimJBusRD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    public static @JsonAutowired(value = Payment.class, filepath = "src\\main\\java\\com\\kamalMakarimJBusRD\\json\\payment.json") JsonTable<Payment> paymentTable;

    public PaymentController(){}

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @RequestMapping(value="/makeBooking", method= RequestMethod.POST)
    public BaseResponse<Payment> makeBooking(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int busId,
            @RequestParam List<String> busSeats,
            @RequestParam String departureDate){
        Predicate<Account> p1 = a -> a.id == buyerId;
        Predicate<Bus> p2 = b -> b.id == busId;
        Account buyer = Algorithm.find(AccountController.accountTable, p1);
        Bus bus = Algorithm.find(BusController.busTable, p2);
        if(buyer == null){
            return new BaseResponse<>(false, "Account not found", null);
        }
        if(bus == null){
            return new BaseResponse<>(false, "Bus not found", null);
        }
        if(buyer.balance < bus.price.price * busSeats.size()){
            return new BaseResponse<>(false, "Insufficient balance", null);
        }
        Timestamp scheduleTime;
        try {
            DateTimeFormatter formatterChecker = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            scheduleTime = Timestamp.valueOf(LocalDateTime.parse(departureDate, formatterChecker));
        } catch (DateTimeParseException e) {
            return new BaseResponse<>(false, "Invalid time format", null);
        }

        Predicate<Schedule> p3 = s -> s.departureSchedule.equals(scheduleTime);
        Schedule schedule = Algorithm.find(bus.schedules.iterator(), p3);
        if(schedule == null){
            return new BaseResponse<>(false, "Schedule not found", null);
        }


        if(Payment.makeBooking(scheduleTime, busSeats, bus)){
            Payment payment = new Payment(buyerId, renterId, busId, busSeats, scheduleTime);
            payment.status = Invoice.PaymentStatus.WAITING;
            paymentTable.add(payment);
            return new BaseResponse<>(true, "Booking made", payment);
        }

        return new BaseResponse<>(false, "Cant make booking", null);
    }

    @RequestMapping(value="/{id}/accept", method= RequestMethod.POST)
    public BaseResponse<Payment> accept(@PathVariable int id){
        Predicate<Payment> p = p1 -> p1.id == id;
        Payment payment = Algorithm.find(paymentTable, p);
        if(payment == null){
            return new BaseResponse<>(false, "Payment not found", null);
        }
        if(payment.status != Invoice.PaymentStatus.WAITING){
            return new BaseResponse<>(false, "Payment not waiting", null);
        }
        payment.status = Invoice.PaymentStatus.SUCCESS;
        Predicate<Account> p2 = a -> a.id == payment.buyerId;
        Account buyer = Algorithm.find(AccountController.accountTable, p2);
        double totalAmount = payment.busSeats.size() * payment.getBus().price.price;
        buyer.balance -= totalAmount;
        return new BaseResponse<>(true, "Payment accepted", payment);
    }

    @RequestMapping(value="/{id}/cancel", method= RequestMethod.POST)
    public BaseResponse<Payment> cancel(@PathVariable int id){
        Predicate<Payment> p = p1 -> p1.id == id;
        Payment payment = Algorithm.find(paymentTable, p);
        Predicate<Account> buyerPredicate = a -> a.id == payment.buyerId;
        Account buyer = Algorithm.find(AccountController.accountTable, buyerPredicate);
        double totalAmount = payment.busSeats.size() * payment.getBus().price.price;
        buyer.balance += totalAmount;
        payment.status = Invoice.PaymentStatus.FAILED;
        //make the bus seat available again
        Predicate<Bus> busPredicate = b -> b.id == payment.getBus().id;
        Bus bus = Algorithm.find(BusController.busTable, busPredicate);
        Predicate<Schedule> schedulePredicate = s -> s.departureSchedule.equals(payment.departureDate);
        Schedule schedule = Algorithm.find(bus.schedules, schedulePredicate);
        for(String seat : payment.busSeats){
            schedule.seatAvailability.put(seat, true);
        }
        return new BaseResponse<>(true, "Payment cancelled", payment);
    }

    @RequestMapping(value="/getMyPayment", method= RequestMethod.GET)
    public BaseResponse<List<Payment>> getMyPayment(@RequestParam int accountId){
        Predicate<Payment> p = p1 -> p1.buyerId == accountId || p1.renterId == accountId;
        List<Payment> payments = Algorithm.collect(paymentTable, p);
        if(payments == null){
            return new BaseResponse<>(false, "Payment not found", null);
        }
        return new BaseResponse<>(true, "Payment found", payments);
    }
}


