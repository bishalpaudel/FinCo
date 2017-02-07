package FW.Model.Accounts;

import FW.Transaction.IEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akash on 2/7/2017.
 */
public class Account implements  IAccount {

    private String accountNumber;
    private String abbreviation = "DEF";

    private Double interest = 0.0;

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

    public Double getBalance() {
        return 0.0;
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

    public List<IEntry> getEntries()
    {
        return entries;
    }
}
