package FW.Factories;

import FW.DAO.DAO;
import FW.DAO.SimpleDAO;
import FW.Model.Customer.Company;
import FW.Model.Customer.ICustomer;
import FW.Model.Customer.Person;
import FW.Types.CustomerType;
import FW.Types.DAOType;

/**
 * Created by bishal on 2/8/17.
 */
public abstract class AbstractFactory implements IFactory {
    public ICustomer getCustomer(CustomerType type) {
        if(type == CustomerType.COMPANY){
            return new Company();
        }else if(type == CustomerType.PERSON){
            return new Person();
        }
        return null;
    }

    public DAO getDAO(Enum type){
        if(type == DAOType.SIMPLE){
            return new SimpleDAO();
        }
        return null;
    }

}
