package Bank.Model;

import FW.Model.Accounts.Account;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Report.IReport;
import FW.Transaction.Entry;
import FW.Transaction.IEntry;
import FW.Types.EntryType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public class CheckingsAccount extends Account {
    private Double interestRate = 0.0;

    @Override
    public Double getBalance() {
        Double balance = 0.0;
        for(IEntry entry: getEntries()){
            if(entry.getType() == EntryType.DEPOSIT){
                balance += entry.getAmount();
            }
            else if(entry.getType() == EntryType.WITHDRAW){
                balance -= entry.getAmount();
            }
        }
        return  balance;
    }

    @Override
    public void generateInterest() {
        Double totalBalance = getBalance();
        Double interest = totalBalance * interestRate;
        IEntry entry = new Entry(EntryType.DEPOSIT, new Date().toString(), interest);
    }
}
