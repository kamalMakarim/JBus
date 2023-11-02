package kamalMakarimJBusRD;
import java.util.LinkedHashMap;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * This class represents a schedule for a bus, inclduing departure time
 * and seat availability
 */
public class Schedule {
    public Timestamp departureSchedule;
    public Map<String, Boolean> seatAvailability = new LinkedHashMap<>();

    /**
     * Creates a new schedule instance with the specified de
     * @param departureSchedule The timestamp of the departure schedule
     * @param numberOfSeats The number of available seats
     */
    public Schedule(Timestamp departureSchedule, int numberOfSeats) {
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }

    /**
     * Initialize the seat availability
     * @param numberOfSeats The number of seats used
     */
    private void initializeSeatAvailability(int numberOfSeats) {
        for (int seatNumber = 1; seatNumber <= numberOfSeats; seatNumber++) {
            String sn = (seatNumber < 10) ? "0" + seatNumber : String.valueOf(seatNumber);
            seatAvailability.put("RD" + sn, true);
        }
    }

    /**
     * Check if the parameter seat is available
     * @param seat The name of seat that is going to be checked
     * @return Return true if the seat is available
     */
    public boolean isSeatAvailable (String seat){
        return seatAvailability.containsKey(seat) && seatAvailability.get(seat);
    }

    /**
     * To book a seat by changing the seat to false
     * @param seat The name of the booked seat
     */
    public void bookSeat (String seat){
        if(seatAvailability.containsKey(seat)){
            seatAvailability.put(seat, false);
        }
    }

    /**
     * Print everything about the schedule object
     */
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

    /**
     * Check if all list of seats available
     * @param seats A list of seats that is checked
     * @return Return true if all seats are available
     */
    public boolean isSeatAvailable(List<String> seats){
        for(String seat : seats){
            if(!isSeatAvailable(seat)){
                return false;
            }
        }
        return true;
    }

    /**
     * To book a list of seats
     * @param seats The list of booked seats
     */
    public void bookSeat(List<String> seats) {
        for(String seat : seats){
            bookSeat(seat);
        }
    }

    /**
     * Convert every data in the Schedule object to string
     * @return All data of object in string
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-d HH:mm:ss");
        String formattedDepartureSchedule = dateFormat.format(this.departureSchedule.getTime());

        Predicate<Boolean> isTrue = Boolean::valueOf;

        int occupied = Algorithm.count(seatAvailability.values(), isTrue);
        int all = seatAvailability.size();
        occupied = all - occupied;

        return "Schedule\t: " + formattedDepartureSchedule + "\nOccupied\t: " + occupied + "/" + all;
    }
}
