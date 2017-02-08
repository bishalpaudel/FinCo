package FW;

import FW.Controllers.Controller;
import FW.Controllers.CustomerController;
import FW.Factories.AbstractFactory;
import FW.Factories.DefaultFactory;
import FW.Functors.ActionListeners.*;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Model.Customer.IPerson;
import FW.Model.Customer.Person;
import FW.Observers.ICustomerChangeObserver;
import FW.Report.IReport;
import FW.Report.MonthlyBillingReport;
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
    String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit;
    boolean newaccount;
    private DefaultTableModel myModel;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    FinCo myframe;
    private Object rowdata[];


    JPanel JPanel1 = new JPanel();
    JButton JButton_PerAC = new JButton();
    JButton JButton_CompAC = new JButton();
    JButton JButton_Deposit = new JButton();
    JButton JButton_Withdraw = new JButton();
    JButton JButton_Addinterest= new JButton();
    JButton JButton_MonthlyReport= new JButton();
    JButton JButton_Exit = new JButton();

    public FinCo() {
        myframe = this;
        InstanceManager.setAppInstance(this);

        setTitle("Bank Application.");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(575,310);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0,0,575,310);

        JScrollPane1 = new JScrollPane();

        myModel = new DefaultTableModel();

        JTable1 = new CustomersTableView(myModel);
        attachAccountChangeObserver((ICustomerChangeObserver) JTable1);

        newaccount=false;


        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

        JButton_PerAC.setText("Add personal account");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24,20,192,33);

        JButton_CompAC.setText("Add company account");
        JButton_CompAC.setActionCommand("jbutton");
        JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240,20,192,33);

        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468,104,96,33);

        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setBounds(468,164,96,33);

        JButton_Addinterest.setBounds(448,20,106,33);
        JButton_Addinterest.setText("Add interest");
        JPanel1.add(JButton_Addinterest);

        JButton_MonthlyReport.setBounds(468,164,96,33);
        JButton_MonthlyReport.setText("Generate Report");
        JPanel1.add(JButton_MonthlyReport);

        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468,248,96,31);
        // lineBorder1.setRoundedCorners(true);
        // lineBorder1.setLineColor(java.awt.Color.green);
        //$$ lineBorder1.move(24,312);

        JButton_PerAC.setActionCommand("jbutton");

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

        setFactory(new DefaultFactory());

    }


    public void setFactory(AbstractFactory factory) {
        InstanceManager.setFactoryInstance(factory);
    }
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
            (new FinCo()).setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
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

    public void addInterestToAllAccounts() {
        List<IAccount> accounts = InstanceManager.getDAO().getAccounts();
        for(IAccount account : accounts){
            account.generateInterest();
        }
    }

    public void generateReport() {
        List<IAccount> accounts = InstanceManager.getDAO().getAccounts();
        for(IAccount account : accounts){
            IReport report= new MonthlyBillingReport(account);
            report.generate();
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
        // to do: code goes here.

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
                JButtonExit_actionPerformed(event);
//            else if (object == JButton_PerAC)
//                JButtonPerAC_actionPerformed(event);
//            else if (object == JButton_CompAC)
//                JButtonCompAC_actionPerformed(event);
//            else if (object == JButton_Deposit)
//                JButtonDeposit_actionPerformed(event);
//            else if (object == JButton_Withdraw)
//                JButtonWithdraw_actionPerformed(event);
//            else if (object == JButton_Addinterest)
//                JButtonAddinterest_actionPerformed(event);

        }
    }

    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(ActionEvent event)
    {
        System.exit(0);
    }

//    void JButtonPerAC_actionPerformed(ActionEvent event)
//    {
//        CustomerController customerController = new CustomerController();
//        customerController.addPerson();
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/

//        JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
//        pac.setBounds(450, 20, 300, 330);
//        pac.show();
//
//        if (newaccount){
//            IPerson person = new Person();
//            person.setName(clientName);
//            person.setCity(city);




//
//            rowdata[0] = accountnr;
//            rowdata[1] = clientName;
//            rowdata[2] = city;
//            rowdata[3] = "P";
//            rowdata[4] = accountType;
//            rowdata[5] = "0";
//            model.addRow(rowdata);
//            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
//            newaccount=false;
//        }



//    }

//    void JButtonCompAC_actionPerformed(ActionEvent event)
//    {
		/*
		 construct a JDialog_AddCompAcc type object
		 set the boundaries and
		 show it
		*/

//        JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
//        pac.setBounds(450, 20, 300, 330);
//        pac.show();

//        if (newaccount){
//            // add row to table
//            rowdata[0] = accountnr;
//            rowdata[1] = clientName;
//            rowdata[2] = city;
//            rowdata[3] = "C";
//            rowdata[4] = accountType;
//            rowdata[5] = "0";
//            model.addRow(rowdata);
//            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
//            newaccount=false;
//        }

//    }

//    void JButtonDeposit_actionPerformed(ActionEvent event)
//    {
//        // get selected name
//        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
//        if (selection >=0){
//            String accnr = (String)myModel.getValueAt(selection, 0);
//
//            //Show the dialog for adding deposit amount for the current mane
//            JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr);
//            dep.setBounds(430, 15, 275, 140);
//            dep.show();
//
//            // compute new amount
//            long deposit = Long.parseLong(amountDeposit);
//            String samount = (String)myModel.getValueAt(selection, 5);
//            long currentamount = Long.parseLong(samount);
//            long newamount=currentamount+deposit;
//            myModel.setValueAt(String.valueOf(newamount),selection, 5);
//        }
//    }

//    void JButtonWithdraw_actionPerformed(ActionEvent event)
//    {
//        // get selected name
//        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
//        if (selection >=0){
//            String accnr = (String)model.getValueAt(selection, 0);
//
//            //Show the dialog for adding withdraw amount for the current mane
//            JDialog_Withdraw wd = new JDialog_Withdraw(myframe,accnr);
//            wd.setBounds(430, 15, 275, 140);
//            wd.show();
//
//            // compute new amount
//            long deposit = Long.parseLong(amountDeposit);
//            String samount = (String)model.getValueAt(selection, 5);
//            long currentamount = Long.parseLong(samount);
//            long newamount=currentamount-deposit;
//            model.setValueAt(String.valueOf(newamount),selection, 5);
//            if (newamount <0){
//                JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
//            }
//        }
//
//
//    }

    public String getSelectedAccount(){
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        return selection >= 0 ? (String) myModel.getValueAt(selection, 0) : "";
    }

    void JButtonAddinterest_actionPerformed(ActionEvent event)
    {
        JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
    }

    public void addAccount(ICustomer customer, IAccount account){
        notifyObservers(customer, account);
        customer.addAccount(account);
        InstanceManager.getDAO().addCutomer(customer);
    }

    public void deposit(IAccount account, double amountDeposit) {
        IEntry entry = new Entry(EntryType.DEPOSIT, new Date().toString(), amountDeposit);
        account.addEntry(entry);
    }

    public void withdraw(IAccount account, double amountWithdraw) {
        IEntry entry = new Entry(EntryType.WITHDRAW, new Date().toString(), amountWithdraw);
        account.addEntry(entry);
    }


    private List<ICustomerChangeObserver> observers = new ArrayList();
    public void attachAccountChangeObserver(ICustomerChangeObserver observer){
        observers.add(observer);
    }
    public void detachAccountChangeObserver(ICustomerChangeObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(ICustomer customer, IAccount account){
        for(ICustomerChangeObserver observer: observers){
            observer.doUpdate(customer, account);
        }
    }
}
