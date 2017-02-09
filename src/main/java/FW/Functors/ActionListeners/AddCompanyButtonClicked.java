package FW.Functors.ActionListeners;

import FW.Views.Dialogs.CompanyForm;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Singletons.InstanceManager;
import FW.Types.AccountType;
import FW.Types.CustomerType;
import FW.Views.IDataAccessView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by bishal on 2/6/17.
 */
public class AddCompanyButtonClicked implements java.awt.event.ActionListener, IDataAccessView {

    JFrame parentFrame;
    public AddCompanyButtonClicked(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void actionPerformed(ActionEvent event) {
//        FinCo finCoForm=null;
        CompanyForm pac = new CompanyForm(parentFrame, this);
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
        account.setAccountNumber(data.get("accountNumber"));

        ICustomer customer = InstanceManager.getFactoryInstance().getCustomer(CustomerType.COMPANY);
        customer.setName(data.get("city"));
        customer.setStreet(data.get("street"));
        customer.setCity(data.get("city"));
        customer.setZip(data.get("zip"));
        customer.setState(data.get("state"));
        customer.setEmail(data.get("email"));



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

        InstanceManager.getControllerInstance().addAccount(customer, account);
    }

    public JFrame getParentFrame(){
        return parentFrame;
    }
}