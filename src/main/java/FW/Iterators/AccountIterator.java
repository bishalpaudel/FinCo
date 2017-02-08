package FW.Iterators;

import FW.Model.Accounts.Account;
import FW.Model.Accounts.DefaultAccount;
import FW.Model.Accounts.IAccount;

import java.util.List;

/**
 * Created by Akash on 2/8/2017.
 */
public class AccountIterator implements IIterator<IAccount> {

    private List<IAccount> _accounts;
    public AccountIterator(List<IAccount> list)
    {
        _accounts = list;
    }

    Integer count = 0;
    public IAccount next()
    {
        IAccount account = null;
        if(hasNext())
        {
            account =  _accounts.get(count);
            count++;
        }
        return account;
    }

    public Boolean hasNext()
    {
        return count < _accounts.size();

    }


}
