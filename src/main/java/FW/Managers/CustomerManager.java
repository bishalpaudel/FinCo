package FW.Managers;

import FW.Model.Customer.ICustomer;
import FW.Observers.ICustomerChangeObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public class CustomerManager {
    List<ICustomer> customers = new ArrayList();

    public List<ICustomerChangeObserver> Observers() {
        return observers;
    }

    public void addObserver(ICustomerChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObservers(ICustomerChangeObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(ICustomerChangeObserver observer: observers){
            observer.update(customers);
        }
    }

    List<ICustomerChangeObserver> observers = new ArrayList();

    public List<ICustomer> getCustomers() {
        return customers;
    }

    public void addCustomer(ICustomer customer) {
        customers.add(customer);
        notifyObservers();
    }


}