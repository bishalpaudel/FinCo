package FW.Factories;

import FW.Model.Accounts.DefaultAccount;
import FW.Model.Accounts.IAccount;
import FW.Types.AccountType;

/**
 * Created by bishal on 2/7/17.
 */
public class DefaultFactory extends AbstractFactory {

    public IAccount getAccount(Enum type) {
        if(type == AccountType.DEFAULT)
            return new DefaultAccount();
        return null;
    }

//    public IEntry getEntry(EntryType type) {
//        return new Entry(EntryType.DEPOSIT, new Date().toString(), );
//    }
}
