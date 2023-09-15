package kamalMakarimJBusRD;
public class Price
{
    // instance variables - replace the example below with your own
    public double price;
    public int discount;
    public double rebate;
    
    public Price(double price){
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }

  
    public Price(double price, int discount){
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    
    public Price(double price, double rebate){
        this.price = price;
        this.discount = 0;
        this.rebate = rebate;
    }
    
    private double getDiscountedPrice(){
        if(this.discount >= 100){
            return 0;
        }
        else{
            return ((float)price * ((100 - discount) / 100));
        }
    }
    
    private double getRebatedPrice(){
        if(this.rebate >= this.price){
            return 0;
        }
        
        else{
            return this.price-this.rebate;
        }
    }
}
