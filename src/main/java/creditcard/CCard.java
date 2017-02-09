package creditcard;

/**
 * Created by bishal on 2/6/17.
 */

import FW.FinCo;

import FW.Observers.ICustomerChangeObserver;
import FW.Singletons.InstanceManager;
import creditcard.ActionListeners.AddCCardAccountButtonClicked;
import creditcard.ActionListeners.CCardDepositButtonClicked;
import creditcard.ActionListeners.CCardWithdrawButtonClicked;
import creditcard.Factories.CCardFactory;
import creditcard.Views.CCAccountTableView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class CCard extends FinCo {

    boolean newaccount;
    private DefaultTableModel myModel;
    private JTable JTable1;
    private JScrollPane JScrollPane1;


    JPanel JPanel1 = new JPanel();
    JButton JButton_NewCCAccount = new JButton();
    JButton JButton_GenBill = new JButton();
    JButton JButton_Deposit = new JButton();
    JButton JButton_Withdraw = new JButton();
    JButton JButton_Exit = new JButton();


    public CCard(){
        InstanceManager.setAppInstance(this);
        InstanceManager.setFactoryInstance(new CCardFactory());
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
            (new CCard()).setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    void initializeViews(){
        setTitle("Credit-card processing Application.");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(575,310);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        myModel = new DefaultTableModel();
        JTable1 = new CCAccountTableView(myModel);
        InstanceManager.getControllerInstance().attachAccountChangeObserver((ICustomerChangeObserver) JTable1);




        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

        JButton_NewCCAccount.setText("Add Credit-card account");
        JPanel1.add(JButton_NewCCAccount);
        JButton_NewCCAccount.setBounds(24,20,192,33);
        JButton_GenBill.setText("Generate Monthly bills");
        JButton_GenBill.setActionCommand("jbutton");
        JPanel1.add(JButton_GenBill);
        JButton_GenBill.setBounds(240,20,192,33);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468,104,96,33);
        JButton_Withdraw.setText("Charge");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setBounds(468,164,96,33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468,248,96,31);


        JButton_GenBill.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_NewCCAccount.addActionListener(new AddCCardAccountButtonClicked(this));
        JButton_GenBill.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(new CCardDepositButtonClicked(this));
        JButton_Withdraw.addActionListener(new CCardWithdrawButtonClicked(this));

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
            if (object == CCard.this)
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
