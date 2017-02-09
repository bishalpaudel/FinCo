package FW;

import FW.Controller.FinCoController;
import FW.DAO.SimpleDAO;
import FW.Factories.IFactory;
import FW.Factories.DefaultFactory;
import FW.Functors.ActionListeners.*;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Observers.ICustomerChangeObserver;
import FW.Report.IReport;
import FW.Report.MonthlyBillingReport;
import FW.Report.ReportGenerator;
import FW.Singletons.InstanceManager;
import FW.Transaction.Entry;
import FW.Transaction.IEntry;
import FW.Types.EntryType;
import FW.Views.CustomersTableView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public class FinCo extends JFrame{
    boolean newaccount;
    private DefaultTableModel myModel;
    private JTable JTable1;
    private JScrollPane JScrollPane1;


    JPanel JPanel1 = new JPanel();
    JButton JButton_PerAC = new JButton();
    JButton JButton_CompAC = new JButton();
    JButton JButton_Deposit = new JButton();
    JButton JButton_Withdraw = new JButton();
    JButton JButton_Addinterest= new JButton();
    JButton JButton_MonthlyReport= new JButton();
    JButton JButton_Exit = new JButton();



    /*****************************************************
     * The entry point for this application.
     * Sets the Look and Feel to the System Look and Feel.
     * Creates a new JFrame1 and makes it visible.
     *****************************************************/
    static public void main(String args[])
    {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            FinCo finco = new FinCo();
            finco.initializeViews();

            InstanceManager.setAppInstance(finco);
            InstanceManager.setDAOInstance(new SimpleDAO());
            InstanceManager.setFactoryInstance(new DefaultFactory());
            finco.setVisible(true);
//            (new FinCo()).setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    void initializeViews(){
        setTitle("Bank Application.");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(625,310);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0,0,575,310);

        JScrollPane1 = new JScrollPane();


        newaccount=false;


        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        myModel = new DefaultTableModel();
        JTable1 = new CustomersTableView(myModel);
        InstanceManager.getControllerInstance().attachAccountChangeObserver((ICustomerChangeObserver) JTable1);
        JTable1.setBounds(0, 0, 420, 0);
        JScrollPane1.getViewport().add(JTable1);

        JButton_PerAC.setText("Add personal account");
        JButton_PerAC.setActionCommand("jbutton");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24,20,192,33);

        JButton_CompAC.setText("Add company account");
        JButton_CompAC.setActionCommand("jbutton");
        JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240,20,192,33);

        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468,104,150,33);

        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setBounds(468,164,150,33);

        JButton_Addinterest.setBounds(468,20,150,33);
        JButton_Addinterest.setText("Add interest");
        JPanel1.add(JButton_Addinterest);

        JButton_MonthlyReport.setBounds(468,200,150,33);
        JButton_MonthlyReport.setText("Generate Report");
        JPanel1.add(JButton_MonthlyReport);

        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468,248,150,31);

        FinCo.SymWindow aSymWindow = new FinCo.SymWindow();
        this.addWindowListener(aSymWindow);
        FinCo.SymAction lSymAction = new FinCo.SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_PerAC.addActionListener(new AddPersonButtonClicked(this));
        JButton_CompAC.addActionListener(new AddCompanyButtonClicked(this));
        JButton_Deposit.addActionListener(new DepositButtonClicked(this));
        JButton_Withdraw.addActionListener(new WithdrawButtonClicked(this));
        JButton_Addinterest.addActionListener(new AddInterestButtonClicked(this));
        JButton_MonthlyReport.addActionListener(new MonthlyReportButtonClicked(this));

    }

    void exitApplication()
    {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(WindowEvent event)
        {
            Object object = event.getSource();
            if (object == FinCo.this)
                BankFrm_windowClosing(event);
        }
    }

    void BankFrm_windowClosing(WindowEvent event)
    {
        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_Exit)
                System.exit(0);
        }
    }

    public JTable getListTable(){
        return JTable1;
    }

    public DefaultTableModel getMyModel(){
        return myModel;
    }


    public Integer getSelectedIndex(){
        return getListTable().getSelectionModel().getMinSelectionIndex();
    }

    public String getSelectedAccount(){
        int selection = getListTable().getSelectionModel().getMinSelectionIndex();
        return selection >= 0 ? (String) getMyModel().getValueAt(selection, 0) : "";
    }
}
