package DataStructures;


import ADTs.ListADT;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.Arrays;

/**
 *
 * @author Cameron East
 * @version 2023-02-01, 1.0
 * @param <T> any use-case data type in later implementation
 */
public abstract class MyArrayList<T> implements ListADT<T> {

    final static int INIT_CAPACITY = 10;
    
    
    T[] items;
    int size;
    
    /**
     * Constructor
     */
    public MyArrayList() {
        items = (T [])(new Object[INIT_CAPACITY]);
        for (int i = 0; i < INIT_CAPACITY; i++ )
            items[i] = null;
        size = 0;
    }
    
    /**
     * Constructor
     * @param size
     */
    public MyArrayList(int size){
        items = (T [])(new Object[size]);
        for (int i = 0; i < size; i++ )
            items[i] = null;
        size = 0;
    }

    /**
     * Obtain the element at the given index of the array
     * @param index
     * @return element
     */
    public T get(int index){
        if (index < 0 || index > items.length){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }
        
        return items[index];
    }
    
    /**
     * Place a given new item (parameter variable called "newitem") at 
     * the given index of the array
     * @param index, newitem
     */
    
    public void set(int index, T newitem){
        if (index < 0 || index > items.length){                 //Throw IndexOutOfBoundsException if index isn't in the ArrayList
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }
        
        items[index] = newitem;
    }

    /**
     * Insert a given new item (parameter variable called value) at the given index
     * of the array
     * @param index, value
     */
    public void add(int index, T value) {                   //Implement jUnit test
        if (size == items.length)
            expandAndCopyArray();
        
        for (int i = size-1; i >= index; i--)
            items[i+1] = items[i];
        
        items[index] = value;
        size++;
        if (items[index] == null)
            size--;
    }
    
    /**
     * Append a given new item (parameter variable called value) to the array
     */
    public void add(T value) {
        add(size, value);
    }
    /**
     * A Java built-in approach to expand the existing array with a new array 
     * of double size.
     */
    private void resize() {
        this.items = Arrays.copyOf(this.items, 2 * this.items.length);
    }
    
    /**
     * Expand the existing array with a new array of double size.
     * It is implemented by making a new array of doubling the size of the old array
     * and copy every element in the old array to the new array.
     */
    private void expandAndCopyArray(){
        if (items == null) return ;
        int resize = (int)(items.length * 2);
        T[] list = (T[])(new Object[resize]);
        for (int index = 0; index < resize; index++)
            if (index < items.length)
                    list[index] = items[index];
            else
                list[index] = null;
        
        this.items = list;
    }

    /**
     * Remove element at the given index of the array
     * @param index the index of the to-be-removed element 
     * @return T
     */
    public T remove(int index) {
         if (index < 0 || index >= size)
             return null;

         T val = items[index];
         for (int i = index + 1; i < items.length; i++)
             items[i-1] = items[i];

         items[size-1] = null;
         size--;

         return val;
       }

    /**
     * Obtain the number of elements in the array
     * @return 
     */
    public int size(){
        return size;
    }

    /**
     * Append the given element to the first of the array
     * @param element
     * @return void
     */
    
    public void addFirst(T element) {
        this.add(0, element);
    }

    /**
     * Append the given element to the end of the array
     * @param element
     * @return void
     */
    
    public void addLast(T element) {
        this.add(size, element);
    }

    /**
     * Remove the element at the first index of the array
     * @return T
     * @throws EmptyCollectionException 
     */
    
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Empty collection error when invoking removeFirst()");
        return this.remove(0);    
    }

    /**
     * Remove the element at the last index of the array
     * @return T
     * @throws EmptyCollectionException 
     */
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Empty collection error when invoking removeLast()");
        return this.remove(size-1);    
    }

    /**
     * Retrieve the element at the first index of the array
     * @return T
     * @throws EmptyCollectionException 
     */
    public T first() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Empty collection error when invoking first()");
        return this.items[0];
    }

    /**
     * Retrieve the element at the last index of the array
     * @return T
     * @throws EmptyCollectionException 
     */
    public T last() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Empty collection error when invoking last()");
        return this.items[size-1];
    }

    /**
     * Evaluate whether the given element is in the array
     * @param element
     * @return true or false
     * @throws EmptyCollectionException 
     */
    public boolean contains(T element) throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Empty collection error when invoking contains()");
        if (element == null) return false;
        
        for (int i = 0; i < size; i++)
            if (items[i].equals(element))
                return true;
        
        return false;
    }

    /**
     * Search for the given element in the array
     * @param element
     * @return 
     * @throws EmptyCollectionException, ElementNotFoundException
     */
    public int find(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) 
            throw new EmptyCollectionException("Empty collection error when invoking find()");
        
        if (element == null) 
            return -1;
        
        for (int i = 0; i < size; i++)
            if (this.items[i].equals(element))
                return i;
        
        throw new ElementNotFoundException("Element not found when invoking find()");
    }
    
    /**
     * Evaluate whether the array is empty or not
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0 ? true : false;
    }
    
    /**
     * Search for the  in the array
     * @param element
     * @return true or false
     * @throws ElementNotFoundException, EmptyCollectionException 
     */
    public void addAfter(T existing, T element) throws ElementNotFoundException, EmptyCollectionException {
        if (existing == null) return;
        
        int index = find(existing);
        add(index+1, element);
    }

    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (element == null) return null;
        
        int index = find(element);
        return remove(index);   
    }
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(10) {};
        list.add(5);
        list.add(1);
        list.add(7);
        list.remove(0);
        
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
