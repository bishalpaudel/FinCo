package FW.Observers;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;

import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public interface ICustomerChangeObserver {
    void doUpdate(ICustomer customer, IAccount account);
}
