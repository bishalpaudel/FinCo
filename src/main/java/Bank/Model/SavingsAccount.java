package Bank.Model;

import FW.Model.Accounts.IAccount;

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
}
