package Bank;

/**
 * Created by bishal on 2/6/17.
 */
import Bank.ActionListeners.*;
import Bank.Factories.BankFactory;
import Bank.Views.BankCustomersTableView;
import FW.Controller.FinCoController;
import FW.Factories.DefaultFactory;
import FW.FinCo;
import FW.Functors.ActionListeners.*;
import FW.Observers.ICustomerChangeObserver;
import FW.Singletons.InstanceManager;
import FW.Views.CustomersTableView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class Bank extends FinCo{

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


    public Bank(){
        InstanceManager.setAppInstance(this);
        InstanceManager.setFactoryInstance(new BankFactory());
        initializeViews();
    }


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
            (new Bank()).setVisible(true);
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
        JTable1 = new BankCustomersTableView(myModel);
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

        JButton_Deposit.setText("DepositForm");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468,104,150,33);

        JButton_Withdraw.setText("WithdrawForm");
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

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_PerAC.addActionListener(new AddBankPersonButtonClicked(this));
        JButton_CompAC.addActionListener(new AddBankCompanyButtonClicked(this));
        JButton_Deposit.addActionListener(new BankDepositButtonClicked(this));
        JButton_Withdraw.addActionListener(new BankWithdrawButtonClicked(this));
        JButton_Addinterest.addActionListener(new AddBankInterestButtonClicked(this));
        JButton_MonthlyReport.addActionListener(new BankMonthlyReportButtonClicked(this));

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
            if (object == Bank.this)
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

    @Override
    public JTable getListTable(){
        return JTable1;
    }

    @Override
    public DefaultTableModel getMyModel(){
        return myModel;
    }

}
