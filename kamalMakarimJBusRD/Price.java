package kamalMakarimJBusRD;
public class Price
{
    // instance variables - replace the example below with your own
    private double price;
    private int discount;
    private double rebate;
    
    public Price(double price)
    {
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }

  
    public Price(double price, int discount)
    {
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    
    public Price(double price, double rebate)
    {
        this.price = price;
        this.discount = 0;
        this.rebate = rebate;
    }
}
