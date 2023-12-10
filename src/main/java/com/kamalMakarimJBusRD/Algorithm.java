
package com.kamalMakarimJBusRD;
import java.util.*;

/**
 * Utility class providing various algorithmic methods.
 */
public class Algorithm {

    private Algorithm(){}

    /**
     * Checks if a given value exists in an array.
     *
     * @param <T>   the type of elements in the array
     * @param array the array to search
     * @param value the value to search for
     * @return true if the value exists in the array, false otherwise
     */
    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    /**
     * Checks if a given value exists in an Iterable collection.
     *
     * @param <T>      the type of elements in the iterable
     * @param iterable the iterable to search
     * @param value    the value to search for
     * @return true if the value exists in the iterable, false otherwise
     */
    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    /**
     * Checks if a given value exists in an Iterator.
     *
     * @param <T>       the type of elements in the iterator
     * @param iterator  the iterator to search
     * @param value     the value to search for
     * @return true if the value exists in the iterator, false otherwise
     */
    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    /**
     * Checks if an array contains an element that matches a given predicate.
     *
     * @param <T>   the type of elements in the array
     * @param array the array to search
     * @param pred  the predicate to test elements against
     * @return true if any element in the array matches the predicate, false otherwise
     */
    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    /**
     * Checks if an Iterable collection contains an element that matches a given predicate.
     *
     * @param <T>      the type of elements in the iterable
     * @param iterable the iterable to search
     * @param pred     the predicate to test elements against
     * @return true if any element in the iterable matches the predicate, false otherwise
     */
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    /**
     * Checks if an Iterator contains an element that matches a given predicate.
     *
     * @param <T>      the type of elements in the iterator
     * @param iterator the iterator to search
     * @param pred     the predicate to test elements against
     * @return true if any element in the iterator matches the predicate, false otherwise
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Collects all elements in an array that match a given value.
     *
     * @param <T>   the type of elements in the array
     * @param array the array to search
     * @param value the value to match
     * @return a list of elements that match the value
     */
    public static <T> List<T> collect(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }

    /**
     * Collects all elements in an Iterable collection that match a given value.
     *
     * @param <T>      the type of elements in the iterable
     * @param iterable the iterable to search
     * @param value    the value to match
     * @return a list of elements that match the value
     */
    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    /**
     * Collects all elements in an Iterator that match a given value.
     *
     * @param <T>      the type of elements in the iterator
     * @param iterator the iterator to search
     * @param value    the value to match
     * @return a list of elements that match the value
     */
    public static <T> List<T>  collect(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    /**
     * Collects all elements in an array that match a given predicate.
     *
     * @param <T>   the type of elements in the array
     * @param array the array to search
     * @param pred  the predicate to match elements against
     * @return a list of elements that match the predicate
     */
    public static <T> List<T>  collect(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    /**
     * Collects all elements in an Iterable collection that match a given predicate.
     *
     * @param <T>      the type of elements in the iterable
     * @param iterable the iterable to search
     * @param pred     the predicate to match elements against
     * @return a list of elements that match the predicate
     */
    public static <T> List<T>  collect(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    /**
     * Collects all elements in an Iterator that match a given predicate.
     *
     * @param <T>      the type of elements in the iterator
     * @param iterator the iterator to search
     * @param pred     the predicate to match elements against
     * @return a list of elements that match the predicate
     */
    public static <T> List<T>  collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> result = new LinkedList<>();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Counts the number of elements in an array that match a given value.
     *
     * @param <T>   the type of elements in the array
     * @param array the array to search
     * @param value the value to match
     * @return the count of matching elements
     */
    public static <T> int count(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    /**
     * Counts the number of elements in an Iterable collection that match a given value.
     *
     * @param <T>      the type of elements in the iterable
     * @param iterable the iterable to search
     * @param value    the value to match
     * @return the count of matching elements
     */
    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    /**
     * Counts the number of elements in an Iterator that match a given value.
     *
     * @param <T>      the type of elements in the iterator
     * @param iterator the iterator to search
     * @param value    the value to match
     * @return the count of matching elements
     */
    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    /**
     * Counts the number of elements in an array that match a given predicate.
     *
     * @param <T>   the type of elements in the array
     * @param array the array to search
     * @param pred  the predicate to match elements against
     * @return the count of matching elements
     */
    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    /**
     * Counts the number of elements in an Iterable collection that match a given predicate.
     *
     * @param <T>      the type of elements in the iterable
     * @param iterable the iterable to search
     * @param pred     the predicate to match elements against
     * @return the count of matching elements
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    /**
     * Counts the number of elements in an Iterator that match a given predicate.
     *
     * @param <T>      the type of elements in the iterator
     * @param iterator the iterator to search
     * @param pred     the predicate to match elements against
     * @return the count of matching elements
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int result = 0;
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                result ++;
            }
        }
        return result;
    }

    /**
     * Finds the first element in an array that matches a given value.
     *
     * @param <T>   the type of elements in the array
     * @param array the array to search
     * @param value the value to match
     * @return the first matching element, or null if none found
     */
    public static <T> T find(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }

    /**
     * Finds the first element in an Iterable collection that matches a given value.
     *
     * @param <T>      the type of elements in the iterable
     * @param iterable the iterable to search
     * @param value    the value to match
     * @return the first matching element, or null if none found
     */
    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    /**
     * Finds the first element in an Iterator that matches a given value.
     *
     * @param <T>      the type of elements in the iterator
     * @param iterator the iterator to search
     * @param value    the value to match
     * @return the first matching element, or null if none found
     */
    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    /**
     * Finds the first element in an array that matches a given predicate.
     *
     * @param <T>   the type of elements in the array
     * @param array the array to search
     * @param pred  the predicate to match elements against
     * @return the first matching element, or null if none found
     */
    public static <T> T find(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, pred);
    }

    /**
     * Finds the first element in an Iterable collection that matches a given predicate.
     *
     * @param <T>      the type of elements in the iterable
     * @param iterable the iterable to search
     * @param pred     the predicate to match elements against
     * @return the first matching element, or null if none found
     */
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    /**
     * Finds the first element in an Iterator that matches a given predicate.
     *
     * @param <T>      the type of elements in the iterator
     * @param iterator the iterator to search
     * @param pred     the predicate to match elements against
     * @return the first matching element, or null if none found
     */
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                return current;
            }
        }
        return null;
    }

    /**
     * Paginates the elements in the array based on the given predicate, page number, and page size.
     *
     * @param <T>      The type of elements in the array.
     * @param array    The array to paginate.
     * @param page     The page number (0-indexed).
     * @param pageSize The number of elements per page.
     * @param pred     The predicate to filter elements.
     * @return A list of paginated elements.
     * @throws IllegalArgumentException if the iterator, predicate is null, page number is negative, or page size is less than 1.
     */
    public static <T> List<T>  paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return paginate(it, page, pageSize, pred);
    }

    /**
     * Paginates the elements in the iterable collection based on the given predicate, page number, and page size.
     *
     * @param <T>      The type of elements in the iterable.
     * @param iterable The iterable to paginate.
     * @param page     The page number (0-indexed).
     * @param pageSize The number of elements per page.
     * @param pred     The predicate to filter elements.
     * @return A list of paginated elements.
     * @throws IllegalArgumentException if the iterator, predicate is null, page number is negative, or page size is less than 1.
     */
    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return paginate(it, page, pageSize, pred);
    }

    /**
     * Paginates the elements in the iterator based on the given predicate, page number, and page size.
     *
     * @param <T>      The type of elements in the iterator.
     * @param iterator The iterator to paginate.
     * @param page     The page number (0-indexed).
     * @param pageSize The number of elements per page.
     * @param pred     The predicate to filter elements.
     * @return A list of paginated elements.
     * @throws IllegalArgumentException if the iterator, predicate is null, page number is negative, or page size is less than 1.
     */
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred){
        if(iterator == null || pred == null || page < 0 || pageSize < 1){
            throw new IllegalArgumentException("Invalid Parameter");
        }

        List <T> res = new LinkedList<>();
        int counter = -1;

        while(iterator.hasNext()){
            T item = iterator.next();
            counter ++;
            if (counter < page * pageSize){
                continue;
            }
            if (counter >= pageSize + (page * pageSize)){
                break;
            }
            if(pred.predicate(item)) {
                res.add(item);
            }
        }

        return res;
    }
}