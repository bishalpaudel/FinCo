package FW.Functors.ActionListeners;

import FW.FinCo;
import FW.Views.Dialogs.WithdrawFom;
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
public class WithdrawButtonClicked implements ActionListener, IDataAccessView {

    FinCo parentFrame;
    private String selectedAccount;
    private Integer selectedIndex;
    public WithdrawButtonClicked(FinCo parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void actionPerformed(ActionEvent event) {

        selectedIndex = parentFrame.getSelectedIndex();
        if(selectedIndex >= 0){
            selectedAccount = parentFrame.getSelectedAccount();

            if (selectedAccount != "") {
                WithdrawFom wd = new WithdrawFom(parentFrame, this, selectedAccount);

                wd.setBounds(430, 15, 275, 140);
                wd.show();
            }

            // compute new amount
//            long deposit = Long.parseLong(amountDeposit);
//            String samount = (String)model.getValueAt(selection, 5);
//            long currentamount = Long.parseLong(samount);
//            long newamount=currentamount-deposit;
//            model.setValueAt(String.valueOf(newamount),selection, 5);
//            if (newamount <0){
//                JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
//            }
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