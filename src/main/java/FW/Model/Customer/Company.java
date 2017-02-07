package FW.Model.Customer;

/**
 * Created by bishal on 2/6/17.
 */
public class Company extends  Customer implements ICompany{
    private Integer numberOfEmployees;

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String getAbbreviation() {
        return "COM";
    }

}
