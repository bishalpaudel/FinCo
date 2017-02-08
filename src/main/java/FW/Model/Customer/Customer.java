package FW.Model.Customer;

import FW.Model.Accounts.IAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public class Customer implements ICustomer {

    private String name, street, city, state, zip,email;
    private List<IAccount> accounts = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAbbreviation() {
        return "CUST";
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String strEmail)
    {
        email = strEmail;
    }

    @Override
    public String toString() {
        return "[Name: "+ name +"]";
    }

    public void addAccount(IAccount account) {
        accounts.add(account);
    }
    public List<IAccount> getAccounts() {
        return accounts;
    }

}
