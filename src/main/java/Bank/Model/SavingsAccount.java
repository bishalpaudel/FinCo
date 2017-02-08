package Bank.Model;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Report.IReport;
import FW.Transaction.IEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public class SavingsAccount implements IAccount{
    public String getAccountNumber() {
        return null;
    }

    public void setAccountNumber(String accountNumber) {

    }

    public Double getBalance() {
        return 0.0;
    }

    public String getAbbreviation() {
        return "SAVINGS";
    }

    public Boolean withdraw(IEntry withdraw) {


        // Update the logic to withdraw
        entries.add(withdraw);
        return true;
    }

    public Boolean deposit(IEntry deposit) {

        entries.add(deposit);
        return true;
    }

    public Boolean addInterest(Double interestAmt) {
        interest = interestAmt;
        // Update logic to update new interest
        return true;
    }

    public Boolean addEntry(IEntry entry)
    {
        entries.add(entry);
        return true;
    }

    public void setCustomer(ICustomer cust)
    {
        customer = cust;
    }
    public ICustomer getCustomer()
    {
        return customer;
    }

    public void generateReport(IReport report)
    {

    }
    private ICustomer customer;

    public List<IEntry> getEntries()
    {
        return entries;
    }

    private List<IEntry> entries = new ArrayList<IEntry>();
    private Double interest = 0.0;
}
