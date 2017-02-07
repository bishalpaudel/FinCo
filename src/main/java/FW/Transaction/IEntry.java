package FW.Transaction;

import FW.Types.EntryType;

/**
 * Created by Akash on 2/6/2017.
 */
public interface IEntry {

        EntryType getType();
        double getAmount();
        String getDate();

}
