package FW.Report;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Transaction.IEntry;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by Akash on 2/7/2017.
 */
public class MonthlyBillingReport implements IReport {

    private IAccount account;
    public MonthlyBillingReport(IAccount acc)
    {
        account = acc;
    }

    public void generate()
    {
        ICustomer customer = account.getCustomer();
//        System.out.println("Name : " + customer.getName());
//        System.out.println("State : " + customer.getState());

        //TODO : Need to change logic to get monthly
        List<IEntry> entries = account.getEntries();



        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("C:/Users/Akash KC/Desktop/ASD/monthlybillingreport.csv");

            //Write the CSV file header
            fileWriter.append("Transaction Type, Date, Amount");

            //Add a new line separator after the header
            fileWriter.append("\n");

            //Write a new student object list to the CSV file
            for (IEntry entry : entries) {
                fileWriter.append(entry.getType().toString());
                fileWriter.append(",");
                fileWriter.append(entry.getDate());
                fileWriter.append(",");
                fileWriter.append(Double.toString(entry.getAmount()));
                fileWriter.append("\n");
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }






//        if(entries.size() > 0)
//        {
//            System.out.println("Type \t Date \t Amount");
//            for(IEntry entry : entries)
//            {
//
//
//                System.out.println(entry.getType() + " \t " + entry.getDate() + " \t " + entry.getAmount());
//            }
//
//
//        }
    }
}
