package FW.Model.Accounts;

import FW.Model.Customer.ICustomer;
import FW.Report.IReport;
import FW.Transaction.Entry;
import FW.Transaction.IEntry;
import FW.Types.EntryType;

import java.util.Date;
import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public class DefaultAccount extends  Account{
//    private String accountNumber;
    private String abbreviation = "DEF";
    Double interestRate = 0.0;

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


//    public String getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }

    public String getAbbreviation() {
        return abbreviation;
    }

//    public Double getBalance() {
//        return 0.0;
//    }
//
//    public Boolean withdraw(IEntry entry) {
//
//        return false;
//    }
//
//    public Boolean deposit(IEntry deposit) {
//        return false;
//    }
//
//    public Boolean addIntere
//
// st(Double interestAmt) {
//        return false;
//    }
//
//    public Boolean addEntry(IEntry entry)
//    {
//        return false;
//    }
//
//    public List<IEntry> getEntries()
//    {
//        return null;
//    }


    public void generateInterest() {
        Double totalBalance = getBalance();
        Double interest = totalBalance * interestRate;
        IEntry entry = new Entry(EntryType.DEPOSIT, new Date().toString(), interest);
    }
}
