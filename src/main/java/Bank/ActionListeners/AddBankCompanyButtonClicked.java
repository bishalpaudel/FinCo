package Bank.ActionListeners;

import Bank.Types.AccountType;
import Bank.Views.Dialogs.CompanyForm;
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
        CompanyForm pac = new CompanyForm(parentFrame, this);
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

        System.out.println("---------");
        System.out.println(data.get("accountNumber"));
        account.setAccountNumber(data.get("accountNumber"));
        System.out.println(account.getAccountNumber());

        ICustomer customer = InstanceManager.getFactoryInstance().getCustomer(CustomerType.COMPANY);
        customer.setName(data.get("city"));
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