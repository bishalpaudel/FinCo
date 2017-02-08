package FW.Views;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by Dev on 2/7/2017.
 */
public interface DataAccessView {
    void setData(HashMap<String, String> data);
    JFrame getParentFrame();
}
