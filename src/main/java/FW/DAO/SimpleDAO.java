package FW.DAO;

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

    public List<IAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(IAccount account){
        accounts.add(account);
    }

    public IAccount getAccount(String accountNumber) {
        for(ICustomer c: customers){
            for(IAccount account: c.getAccounts()){
                if(account.getAccountNumber().equals(accountNumber)){
                    return account;
                }
            }
        }
        return null;
    }

}
