package FW.Functors.ActionListeners;

import FW.FinCo;
import FW.JDialog_AddCompAcc;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Singletons.InstanceManager;
import FW.Types.AccountType;
import FW.Types.CustomerType;
import FW.Views.DataAccessView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by bishal on 2/6/17.
 */
public class AddCompanyButtonClicked implements java.awt.event.ActionListener, DataAccessView {

    JFrame parentFrame;
    public AddCompanyButtonClicked(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void actionPerformed(ActionEvent event) {
//        FinCo finCoForm=null;
        JDialog_AddCompAcc pac = new JDialog_AddCompAcc(parentFrame, this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

//        if (newaccount){
//            // add row to table
//            rowdata[0] = accountnr;
//            rowdata[1] = clientName;
//            rowdata[2] = city;
//            rowdata[3] = "C";
//            rowdata[4] = accountType;
//            rowdata[5] = "0";
//            model.addRow(rowdata);
//            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
//            newaccount=false;
//        }
    }

    public void setData(HashMap<String, String> data){
        IAccount account = InstanceManager.getFactoryInstance().getAccount(AccountType.DEFAULT);
        ICustomer customer = InstanceManager.getFactoryInstance().getCustomer(CustomerType.COMPANY);
        account.setAccountNumber(data.get("accountNumber"));

        InstanceManager.getController().addAccount(customer, account);
    }

    public JFrame getParentFrame(){
        return parentFrame;
    }
}