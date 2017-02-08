package FW.Model;

/**
 * Created by Akash on 2/8/2017.
 */
public  class Settings {

    private static String exportReportDirectory = "D:/";

    public static String getExportReportDirectory()
    {
        return exportReportDirectory;
    }

    public static void setExportReportDirectory(String path)
    {
        exportReportDirectory = path;
    }
}
