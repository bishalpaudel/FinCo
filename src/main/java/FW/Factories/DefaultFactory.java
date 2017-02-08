package FW.Factories;

import FW.Model.Accounts.DefaultAccount;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.Company;
import FW.Model.Customer.ICustomer;
import FW.Model.Customer.Person;
import FW.Transaction.Entry;
import FW.Transaction.IEntry;
import FW.Types.AccountType;
import FW.Types.CustomerType;
import FW.Types.EntryType;

import java.util.Date;

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
        if(type == AccountType.DEFAULT)
            return new DefaultAccount();
        return null;
    }

//    public IEntry getEntry(EntryType type) {
//        return new Entry(EntryType.DEPOSIT, new Date().toString(), );
//    }
}
