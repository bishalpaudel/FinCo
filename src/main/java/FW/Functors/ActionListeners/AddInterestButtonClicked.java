package FW.Functors.ActionListeners;

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
public class AddInterestButtonClicked implements ActionListener, IDataAccessView {

    FinCo parentFrame;
    public AddInterestButtonClicked(FinCo parentFrame) {
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