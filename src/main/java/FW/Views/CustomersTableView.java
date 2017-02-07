package FW.Views;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Observers.ICustomerChangeObserver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public class CustomersTableView extends JTable implements ICustomerChangeObserver {

    DefaultTableModel model;

    public CustomersTableView(DefaultTableModel model) {
        super(model);
        this.model = model;
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
    }

    public void update(List<ICustomer> customers) {
        model.setRowCount(0);
        for(ICustomer customer : customers){
            for(IAccount account: customer.getAccounts()){
                Object rowdata[] = new Object[8];
                rowdata[0] = account.getAccountNumber();
                rowdata[1] = customer.getName();
                rowdata[2] = customer.getCity();
                rowdata[3] = customer.getAbbreviation();
                rowdata[4] = account.getAbbreviation();
                rowdata[5] = account.getBalance();
                model.addRow(rowdata);
                this.getSelectionModel().setAnchorSelectionIndex(-1);
            }
        }
    }
}