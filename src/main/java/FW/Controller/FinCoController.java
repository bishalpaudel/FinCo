package FW.Controller;

import FW.Command.*;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Observers.ICustomerChangeObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bishal on 2/8/17.
 */
public class FinCoController {

    public void addInterestToAllAccounts() {

        IActionCommand addInterestCommand = new AddInterestCommand(new ActionExecuter());
        CommandManager commandManager = new CommandManager(addInterestCommand);
        commandManager.invoke();
    }

    public void generateReport() {
        IActionCommand generateReportCommand = new GenerateReportCommand(new ActionExecuter());
        CommandManager commandManager = new CommandManager(generateReportCommand);
        commandManager.invoke();
    }


    public void addAccount(ICustomer customer, IAccount account){

        IActionCommand addAccountCommand = new AddAccountCommand(new ActionExecuter(), customer, account);
        CommandManager commandManager = new CommandManager(addAccountCommand);
        commandManager.invoke();
        notifyObservers(customer, account);
    }

    public void deposit(IAccount account, double amountDeposit) {

        IActionCommand depositCommand = new DepositCommand(new ActionExecuter(), account, amountDeposit);
        CommandManager commandManager = new CommandManager(depositCommand);
        commandManager.invoke();
    }

    public void withdraw(IAccount account, double amountWithdraw) {

        IActionCommand withdrawCommand = new WithdrawCommand(new ActionExecuter(), account, amountWithdraw);
        CommandManager commandManager = new CommandManager(withdrawCommand);
        commandManager.invoke();
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
