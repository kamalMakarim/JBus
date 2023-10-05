package kamalMakarimJBusRD;
import java.util.LinkedHashMap;
import java.util.Calendar;
import java.util.Map;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Schedule {
    public Timestamp departureSchedule;
    public Map<String, Boolean> seatAvailability = new LinkedHashMap<>();

    public Schedule(Timestamp departureSchedule, int numberOfSeats) {
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }

    private void initializeSeatAvailability(int numberOfSeats) {
        for (int seatNumber = 1; seatNumber <= numberOfSeats; seatNumber++) {
            String sn = (seatNumber < 10) ? "0" + seatNumber : String.valueOf(seatNumber);
            seatAvailability.put("RD" + sn, true);
        }
    }
    
    /* versi cs
    public void printSchedule() {
        for (Map.Entry<String, Boolean> entry : seatAvailability.entrySet()) {
            String seat = entry.getKey();
            Boolean isAvailable = entry.getValue();
    
            System.out.println("Seat: " + seat + ", Available: " + isAvailable);
        }
    }
    */
    
    public boolean isSeatAvailable (String seat){
        return seatAvailability.containsKey(seat) && seatAvailability.get(seat);
    }
    
    public void bookSeat (String seat){
        if(seatAvailability.containsKey(seat)){
            seatAvailability.put(seat, false);
        }
    }
    
    public void printSchedule() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss");
        String formattedDepartureSchedule = dateFormat.format(this.departureSchedule.getTime());
    
        System.out.println("Tanggal keberangkatan: " + formattedDepartureSchedule);
        System.out.println("Daftar kursi dan ketersediaan kursinya: ");
     
        int maxSeatsPerRow = 4; 
        int currentSeat = 1;
        for (String seat : this.seatAvailability.keySet()) {
            String symbol = this.seatAvailability.get(seat)? "O" : "X";
            System.out.print(seat + " : " + symbol + "\t");
            if (currentSeat % maxSeatsPerRow == 0) {
                System.out.println();
            }
            currentSeat ++;
        }
        System.out.println("\n");
    }
    
}
