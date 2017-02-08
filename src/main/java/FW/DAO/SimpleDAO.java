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

    public IAccount getAccount(String acountNumber) {
        for(ICustomer c: customers){
            for(IAccount account: accounts){
                if(account.getAccountNumber().equals(acountNumber)){
                    return account;
                }
            }
        }
        return null;
    }

//    public List<IEntry> getEntries() {
//        return null;
//    }
}
