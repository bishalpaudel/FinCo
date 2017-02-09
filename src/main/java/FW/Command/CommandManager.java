package FW.Command;

/**
 * Created by Akash on 2/8/2017.
 */
public class CommandManager {

    private IActionCommand command;
    public CommandManager(IActionCommand cmd)
    {
        command = cmd;
    }

    public void invoke()
    {
        command.execute();
    }
}
