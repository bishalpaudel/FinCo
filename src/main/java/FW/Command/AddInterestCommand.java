package FW.Command;

import javax.swing.*;

/**
 * Created by Akash on 2/8/2017.
 */
public class AddInterestCommand implements IActionCommand {

    private ActionExecuter actionExecuter;

    public AddInterestCommand(ActionExecuter executer)
    {
        actionExecuter = executer;
    }

    public void execute()
    {
        actionExecuter.addInterestToAllAccounts();
    }
}
