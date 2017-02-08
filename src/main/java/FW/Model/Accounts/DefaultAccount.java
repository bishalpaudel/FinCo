package FW.Model.Accounts;

import FW.Model.Customer.ICustomer;
import FW.Report.IReport;
import FW.Transaction.IEntry;

import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public class DefaultAccount implements IAccount{
    private String accountNumber;
    private String abbreviation = "DEF";

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Double getBalance() {
        return 0.0;
    }

    public Boolean withdraw(IEntry entry) {

        return false;
    }

    public Boolean deposit(IEntry deposit) {
        return false;
    }

    public Boolean addInterest(Double interestAmt) {
        return false;
    }

    public Boolean addEntry(IEntry entry)
    {
        return false;
    }

    public List<IEntry> getEntries()
    {
        return null;
    }

    public void setCustomer(ICustomer customer)
    {
        customer = customer;
    }
    public ICustomer getCustomer()
    {
        return customer;
    }

    public void generateReport(IReport report)
    {

    }
    private ICustomer customer;
}
