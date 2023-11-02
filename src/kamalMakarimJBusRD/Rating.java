package kamalMakarimJBusRD;

/**
 * Represent the rating of customers
 */
public class Rating
{
    private long count;
    private long total;

    /**
     * To construct rating with the initialization of
     * 0 count and 0 total
     */
    public Rating(){
        this.count = 0;
        this.total = 0;
    }

    /**
     * Add the rating variable by the parameter
     * @param rating The amount of rating that is added
     */
    public void insert (int rating){
        this.count += 1;
        this.total += rating;
    }

    /**
     * Get the total variable
     * @return The total of the rating object
     */
    public long getTotal(){
        return this.total;
    }

    /**
     * Get the count variable
     * @return The count of the rating object
     */
    public long getCount(){
        return this.count;
    }

    /**
     * Get the average ratings
     * @return Average of ratings
     */
    public double getAverage() {
        return (count == 0) ? 0.0 : (double) total / count;
    }


    /**
     * To convert all data of the Rating object to string
     * @return A string version of all data in the Rating object
     */
    public String toString(){
        return "count: " + count + "\ttotal: " + total;
    }
}
