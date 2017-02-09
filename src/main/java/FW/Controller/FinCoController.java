package FW.Controller;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Observers.ICustomerChangeObserver;
import FW.Report.IReport;
import FW.Report.MonthlyBillingReport;
import FW.Report.ReportGenerator;
import FW.Singletons.InstanceManager;
import FW.Transaction.Entry;
import FW.Transaction.IEntry;
import FW.Types.EntryType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bishal on 2/8/17.
 */
public class FinCoController {

    public void addInterestToAllAccounts() {
        List<IAccount> accounts = InstanceManager.getDAO().getAccounts();
        for(IAccount account : accounts){
            account.generateInterest();
        }
    }

    public void generateReport() {
        List<IAccount> accounts = InstanceManager.getDAO().getAccounts();
        for(IAccount account : accounts){
            IReport report= new MonthlyBillingReport(account);
            ReportGenerator reportGenerator = new ReportGenerator(report);
            reportGenerator.generate();
        }
    }


    public void addAccount(ICustomer customer, IAccount account){
        String accountNum = account.getAccountNumber();
        notifyObservers(customer, account);
        customer.addAccount(account);
        account.setCustomer(customer);
        InstanceManager.getDAO().addCutomer(customer);
    }

    public void deposit(IAccount account, double amountDeposit) {
        IEntry entry = new Entry(EntryType.DEPOSIT, new Date().toString(), amountDeposit);
        account.addEntry(entry);
    }

    public void withdraw(IAccount account, double amountWithdraw) {
        IEntry entry = new Entry(EntryType.WITHDRAW, new Date().toString(), amountWithdraw);
        account.addEntry(entry);
    }


    private List<ICustomerChangeObserver> observers = new ArrayList();
    public void attachAccountChangeObserver(ICustomerChangeObserver observer){
        observers.add(observer);
    }
    public void detachAccountChangeObserver(ICustomerChangeObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(ICustomer customer, IAccount account){
        for(ICustomerChangeObserver observer: observers){
            observer.doUpdate(customer, account);
        }
    }
}
