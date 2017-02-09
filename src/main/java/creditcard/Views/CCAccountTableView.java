package creditcard.Views;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Observers.ICustomerChangeObserver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by bishal on 2/6/17.
 */
public class CCAccountTableView extends JTable implements ICustomerChangeObserver {

    DefaultTableModel model;

    public CCAccountTableView(DefaultTableModel model1) {
        super(model1);
        model = model1;
        model.addColumn("Name");
        model.addColumn("creditcard number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
    }

    public void doUpdate(ICustomer customer, IAccount account) {
        Object rowdata[] = new Object[5];
        rowdata[0] = customer.getName();
        rowdata[1] = account.getAccountNumber();
        rowdata[2] = account.getExpDate();
        rowdata[3] = account.getAbbreviation();
        rowdata[4] = account.getBalance().toString();

        model.addRow(rowdata);
        getSelectionModel().setAnchorSelectionIndex(-1);
    }
}
