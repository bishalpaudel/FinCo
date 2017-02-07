package FW.DAO;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;

import java.util.List;

/**
 * Created by bishal on 2/7/17.
 */
public interface DAO {
    List<ICustomer> getCustomers();
    List<IAccount> getAccounts();
//    List<IEntry> getEntries();
}
