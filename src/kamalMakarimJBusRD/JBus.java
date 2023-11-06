package kamalMakarimJBusRD;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



public class JBus {
    public static void main(String[] args) throws InterruptedException {
        try {
            JsonTable<Account> table = new JsonTable<Account>(Account.class, "C:\\Java\\OOP2\\JBus\\data\\accountDatabase.json");
            table.add(new Account("Dio", "dio@gmail.com", "Ngikngok"));
            table.writeJson();
            for (Account account : table) {
                System.out.println(account);
            }
        }
        catch (Throwable t){
            t.printStackTrace();
        }

        Bus bus = createBus();
        bus.schedules.forEach(Schedule::printSchedule);
        for(int i =0; i < 10; i++){
            BookingThread thread = new BookingThread("Thread " + i,bus, Timestamp.valueOf("2023-07-27 19:00:00"));
        }
        Thread.sleep(1000);
        bus.schedules.forEach(Schedule::printSchedule);

    }

    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus("Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station("Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station("Halte UI", City.JAKARTA, "Universitas Indonesia"));Timestamp timestamp = Timestamp.valueOf("2023-07-27 19:00:00");
        bus.addSchedule(timestamp);
        return bus;
    }

    public static List<Bus> filterByDeparture(List<Bus> busses, City departure, int page, int pageSize){
        List<Bus> filteredList = new ArrayList<Bus>();
        Predicate<Bus> busPredicate = bus -> bus.departure.city.equals(departure);
        filteredList = Algorithm.collect(busses, busPredicate);
        return Algorithm.paginate(filteredList, page, pageSize, bus -> true);
    }

    public static List<Bus> filterBusId(List<Bus> busses, int id){
        Predicate<Bus> busPredicate = bus -> bus.id == id;
        return Algorithm.collect(busses, busPredicate);
    }

    public static List<Bus> filterByPrice(List<Bus> busses, int min, int max){
        Predicate<Bus> busPredicate = bus ->bus.price.price <= max && bus.price.price >= min;
        return  Algorithm.collect(busses, busPredicate);
    }

    public static List<Bus> filterByDepartureAndArrival(List<Bus> busses, City departure, City arrival, int page, int pageSize){
        List<Bus> filteredList = new ArrayList<Bus>();
        Predicate<Bus> busPredicate = bus -> bus.departure.city.equals(departure) && bus.arrival.city.equals((arrival));
        filteredList = Algorithm.collect(busses, busPredicate);
        return Algorithm.paginate(filteredList, page, pageSize, bus -> true);
    }
}
