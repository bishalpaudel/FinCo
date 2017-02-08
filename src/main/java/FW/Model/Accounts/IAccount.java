package FW.Model.Accounts;

import FW.Model.Customer.ICustomer;
import FW.Report.IReport;
import FW.Transaction.IEntry;

import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public interface IAccount {
    public String getAccountNumber();
    public void setAccountNumber(String accountNumber);
    public String getAbbreviation();
    public Double getBalance();


    public Boolean withdraw(IEntry entry);
    public Boolean deposit(IEntry deposit);
    public Boolean addInterest(Double interestAmt);
    public Boolean addEntry(IEntry entry);

    public List<IEntry> getEntries();

     void setCustomer(ICustomer customer);
     ICustomer getCustomer();

     void generateReport(IReport report);
}
