package FW.Model.Customer;

import FW.Model.Accounts.IAccount;

import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public interface ICustomer {
    String getName();

    void setName(String name);

    String getStreet();

    void setStreet(String street);

    String getCity();

    void setCity(String city);

    String getState();

    void setState(String state);

    String getZip();

    void setZip(String zip);

    String getAbbreviation();

    String getEmail();

    void setEmail(String email);

    void addAccount(IAccount account);

    List<IAccount> getAccounts();

}
