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

    public CustomersTableView(DefaultTableModel model1) {
        super(model1);
        this.model = model1;
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");

//        Object rowdata[] = new Object[6];
//        rowdata[0] = "jwedjn";
//        rowdata[1] = "jwedjn";
//        rowdata[2] = "jwedjn";
//        rowdata[3] = "jwedjn";
//        rowdata[4] = "jwedjn";
//        rowdata[5] = "jwedjn";
//
//        model.addRow(rowdata);
//        this.getSelectionModel().setAnchorSelectionIndex(-1);


    }

    public void update(ICustomer customer, IAccount account) {

//        model.setRowCount(0);
//        for(ICustomer customer : customers){
//            for(IAccount account: customer.getAccounts()){\

                Object rowdata[] = new Object[6];
                rowdata[0] = account.getAccountNumber();
                rowdata[1] = customer.getName();
                rowdata[2] = customer.getCity();
                rowdata[3] = customer.getAbbreviation();
                rowdata[4] = account.getAbbreviation();
                rowdata[5] = account.getBalance();
                for(Object o: rowdata){
                    System.out.println(o);
                }
                model.addRow(rowdata);
                this.getSelectionModel().setAnchorSelectionIndex(-1);
                System.out.println("sdfsd");
//            }
//        }
    }
}
