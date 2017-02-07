package FW.Model.Customer;

/**
 * Created by bishal on 2/6/17.
 */
public class Person extends Customer implements IPerson {
    private String birthdate;

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String getAbbreviation() {
        return "PER";
    }

}
