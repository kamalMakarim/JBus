package kamalMakarimJBusRD;

public class Rating
{
    private long count;
    private long total;
    
    public Rating(){
        this.count = 0;
        this.total = 0;
    }
    
    public void insert (int rating){
        this.count += 1;
        this.total += rating;
    }

    public long getTotal(){
        return this.total;
    }
    
    public long getCount(){
        return this.count;
    }
    
    public double getAverage(){
        if(count == 0){
            return 0;
        }
        
        else{
            return (float)this.total/this.count;
        }
    }

    public String toString(){
        return "\ncount: " + count + "\ntotal: " + total;
    }
}
