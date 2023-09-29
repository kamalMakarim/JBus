package kamalMakarimJBusRD;
import java.util.LinkedHashMap;
import java.util.Calendar;
import java.util.Map;


public class Schedule
{
    public Calendar departureSchedule;
    public Map<String, Boolean> seatAvailability;
    
    public Schedule(Calendar departureSchedule, int numberOfSeats){
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
        
    }
    
    private void initializeSeatAvailability(int numberOfSeats){
        this.seatAvailability = new LinkedHashMap();
        int seatNumber;
        for(seatNumber=1 ; seatNumber<= numberOfSeats ; seatNumber++){
            seatAvailability.put("RD"+seatNumber, true);
        }
    }
    
    
}
