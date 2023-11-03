package kamalMakarimJBusRD;
import java.util.ArrayList;
import java.util.List;



public class JBus {
    public static void main(String[] args) {
        try {
            String filepath =
                    "C:\\Java\\OOP2\\JBus\\data\\buses_CS.json";
            JsonTable<Bus> busList = new JsonTable<>(Bus.class,filepath);
            List<Bus> filteredBus = filterByDepartureAndArrival(busList, City.JAKARTA, City.SURABAYA, 0, 3);
            filteredBus.forEach(bus -> System.out.println(bus.toString()));
        }
        catch (Throwable t){
            t.printStackTrace();
        }

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
