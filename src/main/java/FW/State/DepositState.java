package FW.State;

/**
 * Created by Akash on 2/8/2017.
 */
public class DepositState implements IEntryState {

    EntryChangeManager changeManager;
    public  DepositState(EntryChangeManager manager)
    {
        changeManager = manager;
    }

    public void update()
    {

    }



}
