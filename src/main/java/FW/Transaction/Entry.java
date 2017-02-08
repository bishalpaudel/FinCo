package FW.Transaction;

import FW.Types.EntryType;

import java.util.Date;

/**
 * Created by Akash on 2/6/2017.
 */
public class Entry  implements IEntry{

    String _date;
    double _amount;
    EntryType _entryType;
    public Entry(EntryType entryType, String date, double amount)
    {
        _entryType = entryType;
        _date = date;
        _amount = amount;
    }
    public double getAmount()
    {
        return _amount;
    }

    public String getDate()
    {
        return _date;
    }

    public EntryType getType()
    {
        return _entryType;
    }
}
