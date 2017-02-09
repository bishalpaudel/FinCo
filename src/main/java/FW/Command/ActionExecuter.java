package FW.Command;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Report.IReport;
import FW.Report.MonthlyBillingReport;
import FW.Report.ReportGenerator;
import FW.Singletons.InstanceManager;
import FW.Transaction.Entry;
import FW.Transaction.IEntry;
import FW.Types.EntryType;

import java.util.Date;
import java.util.List;

/**
 * Created by Akash on 2/8/2017.
 */
public class ActionExecuter {

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

}
