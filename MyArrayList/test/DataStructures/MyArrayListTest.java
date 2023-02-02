
package DataStructures;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ellen
 */
public class MyArrayListTest {
    MyArrayList<Integer> instance;
    final static int INIT_CAPACITY = 10;
    public MyArrayListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        instance = new MyArrayList<Integer>() {};
    }

    /**
     * Test of get method, of class MyArrayList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        Object expResult = null;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        assertEquals(0, instance.size());
    }

    /**
     * Test of set method, of class MyArrayList.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Integer newitem = null;
        instance.set(index, newitem);
        assertEquals(newitem, instance.get(index));
        assertEquals(0, instance.size());
    }

    /**
     * Test of add method, of class MyArrayList
     * with an emphasis on adding a null object.
     */
    @Test
    public void testAdd1() {
        System.out.println("add1");
        Integer value = null;
        // TODO Unit testing of adding a null object, value
        instance.add(value);
        assertEquals(0, instance.size());

        
    }
    
    /**
     * Test of add method, of class MyArrayList
     * with an emphasis on adding a meaningful object.
     */
    @Test
    public void testAdd2() throws EmptyCollectionException, ElementNotFoundException {
        System.out.println("add2");
        Integer value = 3;
        instance.add(value);
        assertEquals(0, instance.find(value));
        // TODO Unit testing of adding an integer object, value
        
        
    }
    
    /**
     * Test of add method, of class MyArrayList
     * with an emphasis on adding a meaningful object after
     * the original array is occupied.
     */
    @Test
    public void testAdd3() {
        System.out.println("add3");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        
        assertEquals(INIT_CAPACITY, instance.size());
        
        // TODO Unit testing of adding an extra object, which int value is INIT_CAPACITY
        instance.add(INIT_CAPACITY+1, INIT_CAPACITY);
        assertEquals(11, instance.size());

        
    }

    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test
    public void testRemove1() {
        System.out.println("remove1");
        Integer tmp = instance.remove(-1);
        assertEquals(null, tmp);
        assertEquals(0, instance.size());
    }
        
    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test
    public void testRemove2() {
        System.out.println("remove2");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        int index = 0;
        Integer result = instance.remove(index);
        assertEquals(index, result.intValue());
        assertEquals(INIT_CAPACITY-1, instance.size());
    }

    /**
     * Test of size method, of class MyArrayList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFirst method, of class MyArrayList.
     */
    @Test
    public void testAddFirst1() {
        System.out.println("addFirst1");
        Integer element = null;
        instance.addFirst(element);
        assertEquals(0, instance.size());
    }

/**
     * Test of addFirst method, of class MyArrayList.
     */
    @Test
    public void testAddFirst2() {
        System.out.println("addFirst2");
        Integer element = 3;
        instance.addFirst(element);
        assertEquals(1, instance.size());
        assertEquals(element.intValue(), instance.get(0).intValue());
    }
    
    /**
     * Test of addLast method, of class MyArrayList.
     */
    @Test
    public void testAddLast1() {
        System.out.println("addLast2");
        Integer element = null;
        instance.addLast(element);
        assertEquals(0, instance.size());
    }
    
    /**
     * Test of addLast method, of class MyArrayList.
     */
    @Test
    public void testAddLast2() {
        System.out.println("addLast2");
        Integer element = 3;
        instance.addLast(element);
        assertEquals(1, instance.size());
        assertEquals(element.intValue(), instance.get(0).intValue());
    }

    /**
     * TODO Test of removeFirst method, of class MyArrayList.
     * In the case of removing the first element from an empty collection
     */
    //TODO
    @Test(expected=EmptyCollectionException.class)
    public void testRemoveFirst1() throws EmptyCollectionException {
        System.out.println("removeFirst1");
        // TODO invoking the removeFirst() method
        instance.removeFirst();
        assertEquals(null, instance.get(0));
    }

    /**
     * Test of removeFirst method, of class MyArrayList.
     */
    @Test
    public void testRemoveFirst2() throws EmptyCollectionException {
        System.out.println("removeFirst2");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        Integer expResult = 0;
        //TODO Unit testing of removing the first element from the well-occupied collection
        assertEquals(expResult, instance.removeFirst());

    }
    
    /**
     * Test of removeLast method, of class MyArrayList.
     */
    @Test(expected=EmptyCollectionException.class)
    public void testRemoveLast1() throws EmptyCollectionException {
        System.out.println("removeLast1");
        instance.removeFirst();
    }

    /**
     * Test of removeFirst method, of class MyArrayList.
     */
    @Test
    public void testRemoveLast2() throws EmptyCollectionException {
        System.out.println("removeLast2");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        Integer expResult = INIT_CAPACITY-1;
        Integer result = instance.removeLast();
        assertEquals(expResult.intValue(), result.intValue());
        assertEquals(INIT_CAPACITY-1, instance.size());
    }

    /**
     * Test of first method, of class MyArrayList.
     */
    @Test(expected=EmptyCollectionException.class)
    public void testFirst1() throws EmptyCollectionException {
        System.out.println("first1");
        instance.first();
    }

    /**
     * Test of first method, of class MyArrayList.
     */
    @Test
    public void testFirst2() throws EmptyCollectionException {
        System.out.println("first2");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        Integer expResult = 0;
        Integer result = instance.first();
        assertEquals(expResult.intValue(), result.intValue());
        assertEquals(INIT_CAPACITY, instance.size());
    }
    
    /**
     * Test of last method, of class MyArrayList.
     */
    @Test(expected=EmptyCollectionException.class)
    public void testLast1() throws EmptyCollectionException {
        System.out.println("last1");
        instance.last();
    }

    /**
     * Test of last method, of class MyArrayList.
     */
    @Test
    public void testLast2() throws EmptyCollectionException {
        System.out.println("last2");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        Integer expResult = INIT_CAPACITY-1;
        Integer result = instance.last();
        assertEquals(expResult.intValue(), result.intValue());
        assertEquals(INIT_CAPACITY, instance.size());
    }

    /**
     * Test of contains method, of class MyArrayList.
     */
    @Test(expected=EmptyCollectionException.class)
    public void testContains1() throws Exception {
        System.out.println("contains1");
        Integer element = null;
        instance.contains(element);
    }

    /**
     * Test of contains method, of class MyArrayList.
     */
    @Test
    public void testContains2() throws Exception {
        System.out.println("contains2");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        Integer element = null;
        assertEquals(false, instance.contains(element));
        assertEquals(INIT_CAPACITY, instance.size());
    }

/**
     * Test of contains method, of class MyArrayList.
     */
    @Test
    public void testContains3() throws Exception {
        System.out.println("contains3");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        Integer element = 3;
        assertEquals(true, instance.contains(element));
        assertEquals(INIT_CAPACITY, instance.size());
    }
    
    /**
     * Test of find method, of class MyArrayList.
     */
    @Test(expected=EmptyCollectionException.class)
    public void testFind1() throws EmptyCollectionException, ElementNotFoundException {
        System.out.println("find1");
        instance.find(new Integer(3));
    }

    /**
     * Test of find method, of class MyArrayList.
     */
    @Test(expected=ElementNotFoundException.class)
    public void testFind2()  throws EmptyCollectionException, ElementNotFoundException {
        System.out.println("find2");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        instance.find(new Integer(13));
    }
    
    /**
     * Test of find method, of class MyArrayList.
     */
    @Test
    public void testFind3()  throws EmptyCollectionException, ElementNotFoundException {
        System.out.println("find3");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        
        int tmp = instance.find(3);
        assertEquals(3, tmp);
        assertEquals(INIT_CAPACITY, instance.size());
    }
    /**
     * Test of isEmpty method, of class MyArrayList.
     */
    @Test
    public void testIsEmpty1() {
        System.out.println("isEmpty1");
        assertEquals(true, instance.isEmpty());
    }

    /**
     * Test of isEmpty method, of class MyArrayList.
     */
    @Test
    public void testIsEmpty2() {
        System.out.println("isEmpty2");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        assertEquals(false, instance.isEmpty());
        assertEquals(INIT_CAPACITY, instance.size());
    }
    /**
     * Test of addAfter method, of class MyArrayList.
     */
    @Test(expected=EmptyCollectionException.class)
    public void testAddAfter1() throws Exception {
        System.out.println("addAfter1");
        Integer existing = 3;
        Integer element = null;
        instance.addAfter(existing, element);
    }
    
    @Test(expected=ElementNotFoundException.class)
    public void testAddAfter2() throws Exception {
        System.out.println("addAfter2");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        Integer existing = 18;
        Integer element = null;
        instance.addAfter(existing, element);
    }
    /**
     * Test of addAfter method, of class MyArrayList.
     */
    @Test
    public void testAddAfter3() throws Exception {
        System.out.println("addAfter3");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        Integer existing = 7;
        Integer element = 17;
        instance.addAfter(existing, element);
        assertEquals(existing, instance.get(existing.intValue()));
        assertEquals(element, instance.get(existing.intValue()+1));
        assertEquals(new Integer(existing.intValue()+1), instance.get(existing.intValue()+2));
        assertEquals(INIT_CAPACITY+1, instance.size());
    }
    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test(expected=EmptyCollectionException.class)
    public void testRemoveElement1() throws Exception {
        System.out.println("remove a given element 1");
        Integer element = 3;
        instance.remove(element);
    }
    
    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test(expected=ElementNotFoundException.class)
    public void testRemoveElement2() throws Exception {
        System.out.println("remove a given element 2");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        Integer element = 17;
        instance.remove(element);
    }
    
    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test
    public void testRemoveElement3() throws Exception {
        System.out.println("remove a given element 3");
        for (int i = 0; i < INIT_CAPACITY; i++)
            instance.add(i, new Integer(i));
        Integer element = 7;
        Integer result = instance.remove(element);
        assertEquals(new Integer(element.intValue()+1), instance.get(element.intValue()));
        assertEquals(new Integer(element.intValue()+2), instance.get(element.intValue()+1));
        assertEquals(null, instance.get(INIT_CAPACITY-1));
        assertEquals(INIT_CAPACITY-1, instance.size());
    }
}
