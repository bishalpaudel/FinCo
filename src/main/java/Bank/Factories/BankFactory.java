package Bank.Factories;

import Bank.Model.CheckingsAccount;
import FW.Factories.AbstractFactory;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import Bank.Model.SavingsAccount;
import FW.Factories.IFactory;
import FW.Types.AccountType;
import FW.Types.CustomerType;

/**
 * Created by bishal on 2/6/17.
 */
public class BankFactory extends AbstractFactory {

    public IAccount getAccount(Enum type) {
        if(type == Bank.Types.AccountType.SAVINGS)
            return new SavingsAccount();
        else if(type == Bank.Types.AccountType.CHECKINGS)
            return new CheckingsAccount();
        return null;
    }
}
