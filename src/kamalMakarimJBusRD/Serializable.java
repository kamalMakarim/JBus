package kamalMakarimJBusRD;

import java.util.HashMap;

/**
 * This class is for giving IDs of objects
 */
public class Serializable {
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    /**
     * Construct an ID of an object
     */
    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if (counter == null) {
            counter = -1;
        }
        counter ++;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    /**
     * Get the last assigned ID for a class.
     *
     * @param cls The class for which you want to retrieve the last assigned ID.
     * @param <T> The type parameter for the class.
     * @return The last assigned ID of the specified class, or 0 if not found.
     */
    public static <T> Integer getLastAssignedId(Class<?> cls) {
        Integer temp = mapCounter.get(cls);
        if (temp != null) {
            return temp;
        }
        return 0;
    }

    /**
     * Set the last assigned ID for a class.
     *
     * @param cls The class for which you want to set the last assigned ID.
     * @param id The ID value to set for the specified class.
     * @param <T> The type parameter for the class.
     * @return The ID that was set for the class.
     */
    public static <T> Integer setLastAssignedId(Class<?> cls, Integer id) {
        mapCounter.put(cls, id);
        return getLastAssignedId(cls);
    }

    /**
     * Compares this object with another object for equality. Two objects are considered equal
     * if they are of the same class and have the same 'id' value.
     *
     * @param obj The object to compare with this object.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Serializable obj) {
        return obj != null && obj.getClass() == this.getClass() && obj.id == id;
    }

    /**
     * Compares this object with another object for equality. Two objects are considered equal
     * if they are of the same class and have the same 'id' value.
     *
     * @param obj The object to compare with this object.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean compareTo(Serializable obj) {
        return obj != null && obj.getClass() == this.getClass() && obj.id == id;
    }

    /**
     * Compares this object with another object for equality. Two objects are considered equal
     * if they are of the same class and have the same 'id' value.
     *
     * @param obj The object to compare with this object.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((Serializable) obj).id == id;
    }
}
