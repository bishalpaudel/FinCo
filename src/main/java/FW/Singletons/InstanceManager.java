package FW.Singletons;

import FW.FinCo;
import FW.Managers.CustomerManager;

/**
 * Created by bishal on 2/6/17.
 */
public class InstanceManager {
    private static FinCo appInstance = null;
    private static CustomerManager customerManagerInstance = null;

    protected InstanceManager() {
        // Don't allow instantiation
    }

    public static void setAppInstance(FinCo app) {
        appInstance = app;
    }

    public static FinCo getAppInstance() {
        if (appInstance == null) {
            appInstance = new FinCo();
        }
        return appInstance;
    }

    public static CustomerManager getCustomerManagerInstance() {
        if (customerManagerInstance == null) {
            customerManagerInstance = new CustomerManager();
        }
        return customerManagerInstance;
    }

    public static void setCustomerManagerInstance(CustomerManager customerManagerInstance) {
        InstanceManager.customerManagerInstance = customerManagerInstance;
    }
}
