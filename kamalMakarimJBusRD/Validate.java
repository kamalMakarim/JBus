package kamalMakarimJBusRD;
import java.util.ArrayList;


/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validate
{
    // instance variables - replace the example below with your own
    public Validate(){
        
    }
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList<Price> filterList = new ArrayList<Price>();
        for(Price price : list){
            if(less == true && price.price <= value){
                filterList.add(price);
            }
            
            if(less = false){
                filterList.add(price);
            }
        }
        return filterList;
    }
}
