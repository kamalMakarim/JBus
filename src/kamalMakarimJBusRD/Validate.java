package kamalMakarimJBusRD;
import java.util.ArrayList;


public class Validate
{
    // instance variables - replace the example below with your own
    public Validate(){
    }
    public static ArrayList<Price> filter(Price[] list, int value, boolean less){
        ArrayList<Price> filterList = new ArrayList<Price>();
        for(Price price : list){
            if(less == true && price.price < value){
                filterList.add(price);
            }
            
            if(less == false && price.price > value){
                filterList.add(price);
            }
        }
        return filterList;
    }
}
