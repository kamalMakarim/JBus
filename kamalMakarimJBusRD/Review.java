package kamalMakarimJBusRD;


public class Review extends Serializable
{
    public String date;
    public String desc;
    
    public Review(int id, String date, String desc){
        super(id);
        this.date = date;
        this.desc = desc;
    }
    
    public String toString(){
        return "\nReviewId: " + id +"\nDate: " + date + "\nDesc: " + desc;
    }
}
