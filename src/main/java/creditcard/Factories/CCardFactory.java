package creditcard.Factories;

import FW.Factories.AbstractFactory;
import FW.Model.Accounts.IAccount;
import creditcard.Model.Bronze;
import creditcard.Model.CCAccount;
import creditcard.Model.Gold;
import creditcard.Model.Silver;
import creditcard.Types.AccountType;

/**
 * Created by bishal on 2/6/17.
 */
public class CCardFactory extends AbstractFactory {

    public IAccount getAccount(Enum type) {
        if(type == AccountType.BRONZE)
            return new Bronze();
        else if(type == AccountType.SILVER)
            return new Silver();
        else if(type == AccountType.GOLD)
            return new Gold();
        return new CCAccount();
    }
}
