package FW.Singletons;

import FW.Controller.FinCoController;
import FW.DAO.DAO;
import FW.DAO.SimpleDAO;
import FW.Factories.IFactory;
import FW.FinCo;

/**
 * Created by bishal on 2/6/17.
 */
public class InstanceManager {
    private static FinCo appInstance = null;
    private static FinCoController controllerInstance = null;
    private static DAO DAOInstance = null;
    private static IFactory factoryInstance = null;

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

    public static void setControllerInstance(FinCoController controller) {
        controllerInstance = controller;
    }

    public static FinCoController getControllerInstance() {
        if (controllerInstance == null) {
            controllerInstance = new FinCoController();
        }
        return controllerInstance;
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

    public static void setFactoryInstance(IFactory fi) {
        factoryInstance = fi;
    }

    public static IFactory getFactoryInstance(){
        return factoryInstance;
    }
}
