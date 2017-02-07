package FW.Singletons;

import FW.DAO.DAO;
import FW.DAO.SimpleDAO;
import FW.FinCo;
import FW.Managers.CustomerManager;

/**
 * Created by bishal on 2/6/17.
 */
public class InstanceManager {
    private static FinCo appInstance = null;
    private static CustomerManager customerManagerInstance = null;
    private static DAO DAOInstance = null;

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

    public static DAO getDAO() {
        if (DAOInstance == null) {
            DAOInstance = new SimpleDAO();
        }
        return DAOInstance;
    }

    public static void setDAOInstance(DAO DAOInstance) {
        InstanceManager.DAOInstance = DAOInstance;
    }
}
