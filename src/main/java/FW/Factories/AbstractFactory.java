package FW.Factories;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.Customer;
import FW.Model.Customer.ICustomer;
import FW.Types.AccountType;
import FW.Types.CustomerType;

/**
 * Created by bishal on 2/6/17.
 */
public interface AbstractFactory {
    ICustomer getCustomer(CustomerType type);
    IAccount getAccount(AccountType type);
}
