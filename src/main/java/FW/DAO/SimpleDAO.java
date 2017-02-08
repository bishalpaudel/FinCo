package FW.DAO;

import FW.Iterators.AccountIterator;
import FW.Iterators.CustomerIterator;
import FW.Iterators.IIterator;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bishal on 2/7/17.
 */
public class SimpleDAO implements DAO {

    List<ICustomer> customers = new ArrayList();

    List<IAccount> accounts = new ArrayList();


    public List<ICustomer> getCustomers() {
        return customers;
    }

    public void addCutomer(ICustomer customer){
        customers.add(customer);
        System.out.println(customer.getName());
    }

    // Get all accounts available from all customers
    public List<IAccount> getAccounts() {

        List<IAccount> listAccounts = new ArrayList<IAccount>();

        IIterator<ICustomer> customerIterator = new CustomerIterator(getCustomers());
        //IIterator<IAccount> accounts = new AccountIterator(getCustomers());

        while(customerIterator.hasNext())
        {
            ICustomer customer = customerIterator.next();
            List<IAccount> accounts = customer.getAccounts();
            IIterator<IAccount> accountIterator = new AccountIterator(accounts);

            while(accountIterator.hasNext())
            {
                listAccounts.add(accountIterator.next());
            }

        }
        return listAccounts;
    }

    public void addAccount(IAccount account){
        accounts.add(account);
    }

    public IAccount getAccount(String accountNumber) {

        IIterator<ICustomer> customerIterator = new CustomerIterator(getCustomers());
        //IIterator<IAccount> accounts = new AccountIterator(getCustomers());

        while(customerIterator.hasNext())
        {
            ICustomer customer = customerIterator.next();
            List<IAccount> accounts = customer.getAccounts();
            IIterator<IAccount> accountIterator = new AccountIterator(accounts);

            while(accountIterator.hasNext())
            {
                IAccount account = accountIterator.next();
                if(account.getAccountNumber().equals(accountNumber)){
                    return account;
                }
            }

        }
        return null;
    }

}
