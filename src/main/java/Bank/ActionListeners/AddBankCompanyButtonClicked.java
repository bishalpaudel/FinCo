package Bank.ActionListeners;

import Bank.Types.AccountType;
import Bank.Views.Dialogs.AddCompanyAccount;
import FW.Views.Dialogs.JDialog_AddCompAcc;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Singletons.InstanceManager;

import FW.Types.CustomerType;
import FW.Views.IDataAccessView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by bishal on 2/6/17.
 */
public class AddBankCompanyButtonClicked implements ActionListener, IDataAccessView {

    JFrame parentFrame;
    public AddBankCompanyButtonClicked(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void actionPerformed(ActionEvent event) {
        AddCompanyAccount pac = new AddCompanyAccount(parentFrame, this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }

    public void setData(HashMap<String, String> data){
        IAccount account;// = InstanceManager.getFactoryInstance().getAccount(FW.Types.AccountType.DEFAULT);

        if(data.get("accountType").equals("Savings")){
            account = InstanceManager.getFactoryInstance().getAccount(AccountType.SAVINGS); // for savingsAccount
        }
        else {
//            if(data.get("accountType").equals("Savings")){
            account = InstanceManager.getFactoryInstance().getAccount(AccountType.CHECKINGS); //for CheckingsAccount
        }

        account.setAccountNumber(data.get("accountNumber"));

        ICustomer customer = InstanceManager.getFactoryInstance().getCustomer(CustomerType.COMPANY);
        customer.setName(data.get("city"));
        customer.setStreet(data.get("street"));
        customer.setCity(data.get("city"));
        customer.setZip(data.get("zip"));
        customer.setState(data.get("state"));



//        person.setName(JTextField_NAME.getText());
//        person.setStreet(JTextField_STR.getText());
//        person.setCity(JTextField_CT.getText());
//        person.setZip(JTextField_ZIP.getText());
//        person.setState(JTextField_ST.getText());

//       clientName = JTextField_NAME.getText();
//       street = JTextField_STR.getText();
//       city = JTextField_CT.getText();
//       zip = JTextField_ZIP.getText();
//       state = JTextField_ST.getText();
//       if (JRadioButton_Chk.isSelected())
//           accountType = "Ch";
//	   else
//           accountType = "S";

        InstanceManager.getAppInstance().addAccount(customer, account);
    }

    public JFrame getParentFrame(){
        return parentFrame;
    }
}