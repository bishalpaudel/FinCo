package FW.Command;

import FW.Model.Accounts.IAccount;

/**
 * Created by Akash on 2/8/2017.
 */
public class GenerateReportCommand implements IActionCommand{

    private ActionExecuter actionExecuter;

    public GenerateReportCommand(ActionExecuter executer)
    {
        actionExecuter = executer;

    }

    public void execute()
    {
        actionExecuter.generateReport();
    }
}
