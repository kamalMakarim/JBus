package kamalMakarimJBusRD;



public class Voucher
{
    // instance variables - replace the example below with your own
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;
    
    public void Voucher(String name,int code , Type type, double minimum, double cut){
        this.name = name;
        this.used = false;
        this.minimum = minimum;
        this.cut = cut;
        this.code = code;
        this.type = type;
    }
    
    public double apply(Price price){
        this.used = true;
        if(type == Type.DISCOUNT){
            this.cut = (0.01* price.discount) * price.price;
        }
        if(type == Type.REBATE){
            this.cut = price.rebate;
        }
        
        return price.price - cut;
    }
    
    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(Price price){
        if(price.price > minimum && used == false){
            return true;
        }
        
        else{
            return false;
        }
    }
}
