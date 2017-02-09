package FW.Command;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;

/**
 * Created by Akash on 2/8/2017.
 */
public class AddAccountCommand implements IActionCommand {

    private ActionExecuter actionExecuter;
    private ICustomer customer;
    private IAccount account;

    public AddAccountCommand(ActionExecuter executer, ICustomer cust, IAccount acc)
    {
        actionExecuter = executer;
        customer = cust;
        account = acc;
    }
    public void execute()
    {
        actionExecuter.addAccount(customer, account);
    }


}
