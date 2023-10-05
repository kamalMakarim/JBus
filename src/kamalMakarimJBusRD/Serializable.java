package kamalMakarimJBusRD;

import java.util.HashMap;

public class Serializable {
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if (counter == null) {
            counter = -1;
        }
        counter ++;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public static <T> Integer getLastAssignedId(Class<?> cls) {
        return mapCounter.get(cls);
    }

    public static <T> Integer setLastAssignedId(Class<?> cls, Integer id) {
        return mapCounter.put(cls, id);
    }

    public boolean equals(Serializable obj) {
        return obj != null && obj.getClass() == this.getClass() && obj.id == id;
    }

    public boolean compareTo(Serializable obj) {
        return obj != null && obj.getClass() == this.getClass() && obj.id == id;
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((Serializable) obj).id == id;
    }
}
