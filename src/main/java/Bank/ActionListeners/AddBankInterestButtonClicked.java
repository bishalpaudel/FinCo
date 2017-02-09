package Bank.ActionListeners;

import FW.Command.ActionExecuter;
import FW.Command.AddInterestCommand;
import FW.Command.CommandManager;
import FW.Command.IActionCommand;
import FW.FinCo;
import FW.Singletons.InstanceManager;
import FW.Views.IDataAccessView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by bishal on 2/6/17.
 */
public class AddBankInterestButtonClicked implements ActionListener, IDataAccessView {

    FinCo parentFrame;
    public AddBankInterestButtonClicked(FinCo parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void actionPerformed(ActionEvent event) {


        InstanceManager.getControllerInstance().addInterestToAllAccounts();
    }

    public void setData(HashMap<String, String> data){
        //just for interface
    }

    public JFrame getParentFrame(){
        return parentFrame;
    }
}