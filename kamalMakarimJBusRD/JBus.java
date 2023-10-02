package kamalMakarimJBusRD;
import java.util.Calendar;
import java.sql.Timestamp;

public class JBus
{   
    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(1, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }
    public static void main(String [] args){
        Bus b = createBus();
        Timestamp schedule1 = Timestamp.valueOf("2023-7-18 15:00:00");
        Timestamp schedule2 = Timestamp.valueOf("2023-7-20 12:00:00");
        b.addSchedule(schedule1, 12);
        b.addSchedule(schedule2, 12);
        b.schedules.forEach(Schedule :: printSchedule);
        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("Make booking at July 19, 2023 15:00:00 Seat BR12");
        System.out.println(Payment.makeBooking(t1, "RD12", b));
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("\nMake booking at July 18, 2023 15:00:00 Seat BR20");
        System.out.println(Payment.makeBooking(t2, "RD20", b));
        System.out.println("\nMake booking at July 18, 2023 15:00:00 Seat BR07");
        System.out.println(Payment.makeBooking(t2, "RD07", b));
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("\nMake booking at July 20, 2023 12:00:00 Seat BR01");
        System.out.println(Payment.makeBooking(t3, "RD01", b));
        System.out.println("\nMake booking at July 20, 2023 12:00:00 Seat BR01 again");
        System.out.println(Payment.makeBooking(t3, "RD01", b));
        System.out.println("\nUpdated Schedule\n");
        b.schedules.forEach(Schedule ::printSchedule);
    }
    /*CS4
    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(1, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }
    public static void main(String [] args){
        Bus testBus = createBus();
        Payment testPayment = new Payment(1, 1, 1, testBus.id, "S1");
        System.out.println(testPayment.getDepartureInfo());
        System.out.println(testPayment.getTime());
        Calendar schedule1 = Calendar.getInstance();
        testBus.addSchedule(schedule1);
        Calendar schedule2 = Calendar.getInstance();
        schedule2.add(Calendar.DAY_OF_MONTH, 3);
        testBus.addSchedule(schedule2);
        for(Schedule s: testBus.schedules){
            testBus.printSchedule(s);
        }
    }
    */
    /*CS4
    public static void main (String[] args){
        Review testReview = new Review(1, "23 Agustus 2023", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Station testDeparture = new Station(2, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya");
        Station testArrival = new Station(3, "Halte UI", City.JAKARTA, "Universitas Indonesia");
        Bus testBus = new Bus(1, "Busway", Facility.AC, testPrice, 50, BusType.REGULER, City.DEPOK, testDeparture, testArrival);
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
    
        System.out.println(testReview);
        System.out.println(testBus);
        System.out.println(testAccount);
        System.out.println(testPrice);
        System.out.println(testRating);
    }
    */
    /*CS 3:
    public static void main (String[] args){
        Payment testPayment = new Payment(1, 1, 1, "A", 1, "A", "A");
        Invoice testInvoice = new Invoice(2, 2, 2, "B");
        Station testStation = new Station (3, "C", City.DEPOK);
        System.out.println(testPayment.print());
        System.out.println(testInvoice.print());
        System.out.println(testStation.print());
    }
    */
    
    /*CS 2:
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
    }*/
    
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
