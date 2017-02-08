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
public class SavingsAccount extends Account{

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
//    public String getAccountNumber() {
//        return null;
//    }
//
//    public void setAccountNumber(String accountNumber) {
//
//    }
//
//    public Double getBalance() {
//        return 0.0;
//    }
//
//    public String getAbbreviation() {
//        return "SAVINGS";
//    }
//
//    public Boolean withdraw(IEntry withdraw) {
//
//
//        // Update the logic to withdraw
//        entries.add(withdraw);
//        return true;
//    }
//
//    public Boolean deposit(IEntry deposit) {
//
//        entries.add(deposit);
//        return true;
//    }
//
//    public Boolean addInterest(Double interestAmt) {
//        interest = interestAmt;
//        // Update logic to update new interest
//        return true;
//    }
//
//    public Boolean addEntry(IEntry entry)
//    {
//        entries.add(entry);
//        return true;
//    }
//
//    public void setCustomer(ICustomer cust)
//    {
//        customer = cust;
//    }
//    public ICustomer getCustomer()
//    {
//        return customer;
//    }
//
//    public void generateReport(IReport report)
//    {
//
//    }
//
//    public void generateInterest() {
//
//    }
//
//    private ICustomer customer;
//
//    public List<IEntry> getEntries()
//    {
//        return entries;
//    }
//
//    private List<IEntry> entries = new ArrayList<IEntry>();
//    private Double interest = 0.0;
}
