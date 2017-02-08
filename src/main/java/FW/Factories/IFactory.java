package FW.Factories;

import FW.DAO.DAO;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.Customer;
import FW.Model.Customer.ICustomer;
import FW.Transaction.IEntry;
import FW.Types.AccountType;
import FW.Types.CustomerType;
import FW.Types.EntryType;

/**
 * Created by bishal on 2/6/17.
 */
public interface IFactory {
    ICustomer getCustomer(CustomerType type);
    IAccount getAccount(Enum type);
//    IEntry getEntry(EntryType type);
    DAO getDAO(Enum type);

}
