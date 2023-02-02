package Apps;



import DataStructures.MyArrayList;
import java.util.Arrays;
import java.time.LocalDate;

/**
 * This class is a wallet which can store any number of concert tickets.
 *
 * @author manuel a perez-quinones
 * @version Fall 2019
 */
public class Wallet {
    MyArrayList<ConcertTicket> tickets;
    
    public Wallet(){
        tickets = new MyArrayList<ConcertTicket>() {};
    }
    /**
     * Add a concert ticket into the array
     *
     * @param ct a concert ticket being added to the wallet
     */
    public void add(ConcertTicket ct) {
        tickets.add(ct);
    }
    
    /**
     * Get the concert ticket at the given index of the wallet
     * @param index
     * @return 
     */
    public ConcertTicket getTicket(int index){
        return tickets.get(index);
    }

    /**
     * place the given concert ticket at the given index of the wallet
     * @param index
     * @return 
     */
    public void setTicket(int index, ConcertTicket ct){
        tickets.set(index, ct);
    }
    
    /**
     * Returns how many tickets are in the wallet.
     *
     * @return the size of the wallet
     */
    public int getSize() {
        return this.tickets.size();
    }
    
     /**
     * Removes the most recently added concert ticket from the wallet
     *
     * @return the concert ticket removed from the wallet
     */
    public ConcertTicket remove() {
        try{
            return this.tickets.removeLast();
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String [] argc){
        Wallet wallet = new Wallet();
        wallet.add(new ConcertTicket("Peter", LocalDate.now(), 18.5));
        wallet.add(new ConcertTicket("Brandon", LocalDate.now(), 28.5));
    }
}
