package kamalMakarimJBusRD;

public class JBus
{
    /*
    public static Bus createBus(){
        Price price = new Price(750000,5);
        Bus bus = new Bus("Netlab Bus", Facility.LUNCH, price, 25);
        return bus;
    }
    
    
    public static void main (String[] args){
        Bus testBus = createBus();
        
        System.out.println(testBus.name);
        System.out.println(testBus.facility);
        System.out.println(testBus.price.price);
        System.out.println(testBus.capacity);
    }
    /* CS 1:
    public static void main (String[] args){
        
        System.out.println("getBusId : " + getBusId());
        System.out.println("getBusName : " + getBusName());
        System.out.println("isDiscount : " + isDiscount());
        System.out.println("getDiscountPrecentage : " + getDiscountPercentage(0,0));
        System.out.println("getDiscountedPrice : " + getDiscountedPrice(0, 0.0f));
        System.out.println("getOriginalPrice : " + getOriginalPrice(0,120.0f));
        System.out.println("getAdminFeePrecantge : " + getAdminFeePercentage());
        System.out.println("getAdminFee : " + getAdminFee(1000));
        System.out.println("getTotalPrice : " + getTotalPrice(10000,2));
    }

   
    public static int getBusId (){
        return 0;
    }
    public static String getBusName (){
        return "Bus";
    }
    public static boolean isDiscount (){
        return true;
    }
    public static float getDiscountPercentage (int beforeDiscount, int afterDiscount){
        if (beforeDiscount - afterDiscount <= 0){
            return 0.0f;
        } else{
            return (float)((beforeDiscount - afterDiscount) / beforeDiscount) * 100.0f;
        }
    }
    public static int getDiscountedPrice (int price, float discountPrecentage){
        
        if (discountPrecentage >= 100){
            return 0;
        }else{
            return price - Math.round((price * (discountPrecentage/100)));
        }
    }
    public static int getOriginalPrice (int discountedPrice, float discountPrecentage){
        if (discountPrecentage >= 100.0f){
            return 0;
        }else{
            return Math.round(discountedPrice / (1f - (discountPrecentage/100f)));
        }
    }
    public static float getAdminFeePercentage (){
        return 0.05f;
    }
    public static int getAdminFee (int price){
        return Math.round(price * getAdminFeePercentage());
    }
    public static int getTotalPrice (int price, int numberOfSeat){
        return (price * numberOfSeat) + getAdminFee(price * numberOfSeat);
    }
    */
}
