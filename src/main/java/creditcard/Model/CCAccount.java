package creditcard.Model;

import FW.Model.Accounts.Account;
import FW.Transaction.Entry;
import FW.Transaction.IEntry;
import FW.Types.EntryType;

import java.util.Date;

/**
 * Created by bishal on 2/6/17.
 */
public class CCAccount extends Account {
    private Double interestRate = 0.0;
    private Date expiryDate = new Date();

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
