package Apps;

import java.time.LocalDate;
import java.util.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ellen
 */
public class WalletTest {
    Wallet instance;
    ConcertTicket ct1, ct2;
    
    public WalletTest() {
        instance = new Wallet();
        
        ct1 = new ConcertTicket("Peter", LocalDate.now(), 18.5);
        ct2 = new ConcertTicket("Brandon", LocalDate.now(), 28.5);

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Wallet();
    }

    /**
     * Test of add method, of class Wallet.
     */
    @Test
    public void testAdd1() {
        System.out.println("add1");
        ConcertTicket ct = null;
        instance.add(ct);
        assertEquals(0, instance.getSize());
    }

/**
     * Test of add method, of class Wallet.
     */
    @Test
    public void testAdd2() {
        System.out.println("add2");
        instance.add(ct1);
        assertEquals(1, instance.getSize());
        assertEquals(ct1, instance.getTicket(0));
    }
    
    /**
     * Test of getTicket method, of class Wallet.
     */
    @Test
    public void testGetTicket() {
        System.out.println("getTicket");
        instance.add(ct1);
        instance.add(ct2);
        assertEquals(ct1, instance.getTicket(0));
        assertEquals(ct2, instance.getTicket(1));
    }

    /**
     * Test of setTicket method, of class Wallet.
     */
    @Test
    public void testSetTicket() {
        System.out.println("setTicket");
        instance.add(ct1);
        instance.add(ct2);
        assertEquals(ct1, instance.getTicket(0));
        assertEquals(ct2, instance.getTicket(1));
        
        instance.setTicket(0, ct2);
        instance.setTicket(1, ct1);
        assertEquals(ct2, instance.getTicket(0));
        assertEquals(ct1, instance.getTicket(1));
    }

    /**
     * Test of getSize method, of class Wallet.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        instance.add(ct1);
        instance.add(ct2);
        assertEquals(2, instance.getSize());
    }

    /**
     * Test of remove method, of class Wallet.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        instance.add(ct1);
        instance.add(ct2);
        instance.remove();
        assertEquals(ct1, instance.getTicket(0));
        assertEquals(1, instance.getSize());
    }
    
}
