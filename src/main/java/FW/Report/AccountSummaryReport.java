package FW.Report;

import FW.DAO.DAO;
import FW.DAO.SimpleDAO;
import FW.FinCo;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Transaction.IEntry;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Akash on 2/7/2017.
 */
public class AccountSummaryReport implements IReport {


    public void generate() {

//        //TODO : Need to change logic to get monthly
//
//        DAO fincoDAO = new SimpleDAO();
//        List<IAccount> accounts = fincoDAO.getAccounts();
//
//
//        //TODO : Need to change logic to get monthly
//        List<IEntry> entries = account.getEntries();
//
//
//
//        FileWriter fileWriter = null;
//
//        try {
//            fileWriter = new FileWriter("C:/Users/Akash KC/Desktop/ASD/accountsummaryreport.csv");
//
//            //Write the CSV file header
//            fileWriter.append("Customer Name, Account Number, State, City");
//
//            //Add a new line separator after the header
//            fileWriter.append("\n");
//
//            //Write a new student object list to the CSV file
//            for (IEntry entry : entries) {
//                fileWriter.append(entry.getType().toString());
//                fileWriter.append(",");
//                fileWriter.append(entry.getDate());
//                fileWriter.append(",");
//                fileWriter.append(Double.toString(entry.getAmount()));
//                fileWriter.append("\n");
//            }
//            System.out.println("CSV file was created successfully !!!");
//
//        } catch (Exception e) {
//            System.out.println("Error in CsvFileWriter !!!");
//            e.printStackTrace();
//        } finally {
//
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println("Error while flushing/closing fileWriter !!!");
//                e.printStackTrace();
//            }
//
//        }

    }
}