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

        //TP Modul 6

        String filepath = "C:\\Java\\OOP2\\JBus\\data\\station.json";
        Gson gson = new Gson();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            List<Station> stationjson = gson.fromJson(bufferedReader, new TypeToken<List<Station>>() {}.getType());
            stationjson.forEach(e -> System.out.println(e.toString()));
            System.out.println();
            bufferedReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
