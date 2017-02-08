package FW.Factories;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.Company;
import FW.Model.Customer.ICustomer;
import FW.Model.Customer.Person;
import FW.Types.AccountType;
import FW.Types.CustomerType;

/**
 * Created by bishal on 2/7/17.
 */
public class DefaultFactory implements AbstractFactory {
    public ICustomer getCustomer(CustomerType type) {
        if(type == CustomerType.COMPANY){
            return new Company();
        }else if(type == CustomerType.PERSON){
            return new Person();
        }
        return null;
    }

    public IAccount getAccount(AccountType type) {
        return null;
    }
}
