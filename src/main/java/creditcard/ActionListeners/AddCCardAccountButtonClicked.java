package creditcard.ActionListeners;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Singletons.InstanceManager;
import FW.Types.CustomerType;
import FW.Views.IDataAccessView;
import creditcard.CCard;
import creditcard.Types.AccountType;
import creditcard.Views.Dialogs.AddAccountForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * Created by bishal on 2/6/17.
 */
public class AddCCardAccountButtonClicked implements ActionListener, IDataAccessView {

    CCard parentFrame;
    public AddCCardAccountButtonClicked(CCard parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void actionPerformed(ActionEvent event) {
        AddAccountForm pac = new AddAccountForm(parentFrame, this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }

    public void setData(HashMap<String, String> data) {
        IAccount account;

        if(data.get("accountType").equals("Gold")){
            account = InstanceManager.getFactoryInstance().getAccount(AccountType.GOLD);
        }
        else if(data.get("accountType").equals("Silver")){
            account = InstanceManager.getFactoryInstance().getAccount(AccountType.SILVER);
        }
        else{
            account = InstanceManager.getFactoryInstance().getAccount(AccountType.BRONZE);
        }

        account.setAccountNumber(data.get("ccnumber"));
        account.setExpDate(data.get("expdate"));

        ICustomer customer = InstanceManager.getFactoryInstance().getCustomer(CustomerType.PERSON);
        customer.setName(data.get("clientName"));
        customer.setStreet(data.get("street"));
        customer.setCity(data.get("city"));
        customer.setZip(data.get("zip"));
        customer.setState(data.get("state"));


        InstanceManager.getControllerInstance().addAccount(customer, account);
    }

    public JFrame getParentFrame(){
        return parentFrame;
    }
}