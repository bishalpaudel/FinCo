package Bank.Factories;

import Bank.Model.CheckingsAccount;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.Company;
import FW.Model.Customer.ICustomer;
import Bank.Model.SavingsAccount;
import FW.Factories.AbstractFactory;
import FW.Model.Customer.Person;
import FW.Types.AccountType;
import FW.Types.CustomerType;

/**
 * Created by bishal on 2/6/17.
 */
public class BankFactory implements AbstractFactory {

    public ICustomer getParty(CustomerType type) {
        return null;
    }

    public IAccount getAccount(String type) {
        if(type == "savings")
            return new SavingsAccount();
        else if(type == "checkings")
            return new CheckingsAccount();
        return null;
    }

    public ICustomer getCustomer(CustomerType type) {
        return null;
    }

    public IAccount getAccount(AccountType type) {
        return null;
    }
}
