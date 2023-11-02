package kamalMakarimJBusRD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.sql.Timestamp;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;





public class JBus {
    public static void main(String[] args) {
        try {
            String filepath =
                    "C:\\Java\\OOP2\\JBus\\data\\buses.json";
            JsonTable<Bus> busList = new JsonTable<>(Bus.class,filepath);
            List<Bus> filteredBus =
                    filterByDeparture(busList,City.JAKARTA,1,10);
            filteredBus.forEach(bus -> System.out.println(bus.toString()));
        }
        catch (Throwable t){
            t.printStackTrace();
        }

    }

    public static List<Bus> filterByDeparture(List<Bus> busses, City departure, int page, int pageSize){
        return Algorithm.paginate(busses, page, pageSize, bus -> bus.departure.city.equals(departure));
    }
}
