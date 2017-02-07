package FW.Factories;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;

/**
 * Created by bishal on 2/6/17.
 */
public interface AbstractFactory {
    ICustomer getParty(String type);
    IAccount getAccount(String type);
}
