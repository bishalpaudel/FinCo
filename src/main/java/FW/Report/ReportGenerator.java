package FW.Report;

/**
 * Created by Akash on 2/8/2017.
 */
public class ReportGenerator {

    private IReport report;
    public ReportGenerator(IReport rep)
    {
        report = rep;
    }

    public void generate()
    {
        report.generate();
    }

}
