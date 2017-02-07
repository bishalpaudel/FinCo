package FW.Model.Accounts;

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
}
