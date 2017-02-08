package FW.Iterators;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Akash on 2/8/2017.
 */
public class CustomerIterator implements IIterator<ICustomer>{

    private List<ICustomer> _customers;
    public CustomerIterator(List<ICustomer> list)
    {
        _customers = list;
    }

    Integer count = 0;
    public ICustomer next()
    {
        ICustomer customer = null;
        if(hasNext())
        {
            customer =  _customers.get(count);
            count++;
        }
        return customer;
    }

    public Boolean hasNext()
    {
        return count < _customers.size();

    }
}
