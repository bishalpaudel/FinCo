package FW.Model.Accounts;

import FW.Model.Customer.ICustomer;
import FW.Report.IReport;
import FW.Report.ReportGenerator;
import FW.Transaction.Entry;
import FW.Transaction.IEntry;
import FW.Types.EntryType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akash on 2/7/2017.
 */
public abstract class Account implements  IAccount {

    private ICustomer customer;
    private String accountNumber;

    private String abbreviation = "DEF";

    private Double interestRate = 0.0;

    private List<IEntry> entries = new ArrayList<IEntry>();

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public abstract Double getBalance();

    private String expiryDate;

    public Boolean withdraw(IEntry withdraw) {


        // Update the logic to withdraw
        entries.add(withdraw);
        return true;
    }

    public Boolean deposit(IEntry deposit) {

        entries.add(deposit);
        return true;
    }

//    }

    public Boolean addEntry(IEntry entry) {
        entries.add(entry);


        if(this.getCustomer().getAbbreviation().equals("COM") || (this.getCustomer().getAbbreviation().equals("PER")&& entry.getAmount() > 500))
        {
                System.out.println("Your transaction has exceeded 500. Email has been sent to " + this.getCustomer().getEmail());
        }


        return true;
    }

    public List<IEntry> getEntries() {
        return entries;
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
        ReportGenerator reportGenerator = new ReportGenerator(report);
        reportGenerator.generate();
    }

    public abstract void generateInterest();

    public String getExpDate() {
        return expiryDate;
    }

    public void setExpDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
