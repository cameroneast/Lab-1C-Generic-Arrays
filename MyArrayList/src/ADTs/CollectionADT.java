package ADTs;

/**
 * An interface for an AbstractDataType
 * Specific ADT interfaces will extend this
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 * @version 1.0
 */
public interface CollectionADT<T> {
    
    /**
     * Returns true if the collection contains no elements
     * @return true if the collection is empty
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in the collection
     * @return the number of elements as an int
     */
    public int size();
    
    /**
     * Returns a string representation of the collection
     * @return a string representation of the collection
     */
    @Override
    public String toString();
}
