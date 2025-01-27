package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void initReport(String reportPath) {
        // Set up Extent Reports
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);


     //   ExtentSparkReporter spark = new ExtentSparkReporter("//src/main/java/reports/TestResults.html");
        spark.config().setReportName("Automation Test Report");
        spark.config().setDocumentTitle("Extent Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("platform"));
        extent.setSystemInfo("Tester", "Rish");
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }


// Your test code here
//ExtentTest test = extent.createTest("My First Mobile Test", "Click Crate Account");


}
