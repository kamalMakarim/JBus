package kamalMakarimJBusRD;

public abstract class Voucher extends Serializable implements FileParser
{
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;
    
    public Voucher(int id, String name,int code , Type type, double minimum, double cut){
        super();
        this.name = name;
        this.used = false;
        this.minimum = minimum;
        this.cut = cut;
        this.code = code;
        this.type = type;
    }

    public double apply(Price price){
        
        if(canApply(price) == false){
            return price.price;
        }
        this.used = true;
        
        if(type == Type.DISCOUNT){    
            if(price.price <= price.rebate){
                this.cut = 100;
            }
            
            else{
                this.cut = (price.rebate * 100) / price.price;
            }
            return price.price - (price.price * (cut * 0.01));
        }
        
    
        this.cut = price.rebate;
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


