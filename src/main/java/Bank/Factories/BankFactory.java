package Bank.Factories;

import Bank.Model.CheckingsAccount;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.Company;
import FW.Model.Customer.ICustomer;
import Bank.Model.SavingsAccount;
import FW.Factories.AbstractFactory;
import FW.Model.Customer.Person;

/**
 * Created by bishal on 2/6/17.
 */
public class BankFactory implements AbstractFactory {
    public ICustomer getParty(String type) {
        if(type == "company")
            return new Company();
        else if(type == "person")
            return new Person();
        return null;
    }

    public IAccount getAccount(String type) {
        if(type == "savings")
            return new SavingsAccount();
        else if(type == "checkings")
            return new CheckingsAccount();
        return null;
    }

}
