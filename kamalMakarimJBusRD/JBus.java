package kamalMakarimJBusRD;

public class JBus
{
    // instance variables - replace the example below with your own
    public static void main (String[] args){
        
        System.out.println("getBusId : " + getBusId());
        System.out.println("getBusName : " + getBusName());
        System.out.println("isDiscount : " + isDiscount());
        System.out.println("getDiscountPrecentage : " + getDiscountPrecentage(1000,900));
        System.out.println("getDiscountedPrice : " + getDiscountedPrice(1000 , 10.0f));
        System.out.println("getOriginalPrice : " + getOriginalPrice(900,10.0f));
        System.out.println("getAdminFeePrecantge : " + getAdminFeePrecentage());
        System.out.println("getAdminFee : " + getAdminFee(1000));
        System.out.println("getTotalPrice : " + getTotalPrice(0,2));
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
    public static float getDiscountPrecentage (int beforeDiscount, int afterDiscount){
        if (beforeDiscount - afterDiscount <= 0){
            return 0.0f;
        } else{
            return ((beforeDiscount - afterDiscount) / beforeDiscount) * 100;
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
        if (discountPrecentage >= 100f){
            return 0;
        }else{
            return Math.round(discountedPrice / (1f - (discountPrecentage/100f)));
        }
    }
    public static float getAdminFeePrecentage (){
        return 0.05f;
    }
    public static int getAdminFee (int price){
        return Math.round(price * getAdminFeePrecentage());
    }
    public static int getTotalPrice (int price, int numberOfSeat){
        return (price * numberOfSeat) + getAdminFee(price * numberOfSeat);
    }
}
