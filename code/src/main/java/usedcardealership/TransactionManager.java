/**
 * Manages all Transactions, has a List<Transaction>
 * 
 * @author Juan Sebastian Badel - 2338127
 * @version 11/4/2024
 */
package usedcardealership;

import java.util.List;

public class TransactionManager {
    private List<Transactions> transactionHistory;

    /**
     * Constructor, Initializes the field transactionHistory
     * 
     * @param transactionHistory a List<Transaction> 
     */
    public TransactionManager(List<Transactions> transactionHistory){
        throw new UnsupportedOperationException("Not Written Yet");
    }

    /**
     * Function sells Vehicle to a Customer, updates the transactionHistory
     * 
     * @param vehicle a Vehicle Object
     * @param customer a Customer object
     * @return Transaction
     */
    public Transaction sellVehicle(Vehicle vehicle, Customer customer){
        // throw new UnsupportedOperationException("Not Written Yet");
        Transaction sale = new Sale(vehicle, customer);  // Since Sale is a subclass of Transaction
        processTransaction(sale);
        return sale;
    }

    /**
     * Function allows Customer to buy a Vehicle, updates the transactionHistory
     * 
     * @param vehicle a Vehicle Object
     * @param customer a Customer object
     * @return Transaction
     */
    public Transaction buyVehicle(Vehicle vehicle, Customer customer){
        // throw new UnsupportedOperationException("Not Written Yet");
        Transaction purchase = new Purchase(vehicle, customer);  // Assume Purchase is a subclass of Transaction
        processTransaction(purchase);
        return purchase;
    }

    /**
     * Function searches transactions based on specified criteria (e.g., filter or sorting criteria )
     * 
     * @param criteria a IFilter sub-type object
     * @return List<Transaction>
     */
    public List<Transaction> searchTransaction(IFilter criteria){
        throw new UnsupportedOperationException("Not Written Yet");
    }

    /**
     * Function processes a transaction
     * 
     * @return void
     */
    private void processTransaction(Transaction transaction){
        //throw new UnsupportedOperationException("Not Written Yet");
        transactionHistory.add(transaction);
    }

    
}
