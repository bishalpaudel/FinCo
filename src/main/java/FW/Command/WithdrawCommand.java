package FW.Command;

import FW.Model.Accounts.IAccount;

/**
 * Created by Akash on 2/8/2017.
 */
public class WithdrawCommand implements IActionCommand {

    private ActionExecuter actionExecuter;
    private IAccount account;
    private double amount = 0;

    public WithdrawCommand(ActionExecuter executer, IAccount acc, double amt)
    {
        actionExecuter = executer;
        account = acc;
        amount = amt;
    }

    public void execute()
    {
        actionExecuter.withdraw(account, amount);
    }
}
