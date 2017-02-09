package Bank.ActionListeners;

import Bank.Views.Dialogs.WithdrawForm;
import FW.FinCo;
import FW.Model.Accounts.IAccount;
import FW.Singletons.InstanceManager;
import FW.Views.IDataAccessView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by bishal on 2/6/17.
 */
public class BankWithdrawButtonClicked implements ActionListener, IDataAccessView {

    FinCo parentFrame;
    private String selectedAccount;
    private Integer selectedIndex;
    public BankWithdrawButtonClicked(FinCo parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void actionPerformed(ActionEvent event) {
        // get selected name
        selectedIndex = parentFrame.getSelectedIndex();
        if(selectedIndex >= 0){
            selectedAccount = (String) parentFrame.getMyModel().getValueAt(selectedIndex, 0);

            if (selectedAccount != "") {
                WithdrawForm wd = new WithdrawForm(parentFrame, this, selectedAccount);

                wd.setBounds(430, 15, 275, 140);
                wd.show();
            }
        }
    }

    public void setData(HashMap<String, String> data){
        IAccount account = InstanceManager.getDAO().getAccount(selectedAccount);
        if(account != null){
            InstanceManager.getControllerInstance().withdraw(account, Double.parseDouble(data.get("amountWithdraw")));
            String balance = String.valueOf(account.getBalance());
            DefaultTableModel model = parentFrame.getMyModel();
            model.setValueAt(balance, selectedIndex, 5);
        }
    }

    public JFrame getParentFrame(){
        return parentFrame;
    }
}