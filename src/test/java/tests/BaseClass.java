package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import software.amazon.awssdk.services.s3.endpoints.internal.Value;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;


//@Listeners(ChainTestListener.class)
public class BaseClass {
    AppiumDriver driver;
    ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest test;
    AndroidDriver driver2;

    UiAutomator2Options options = new UiAutomator2Options();

    @BeforeSuite(groups = {"smoke"})
//    @BeforeTest
    public void frameworkBase() throws IOException {

        ExtentReportManager.initReport(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        //  ExtentSparkReporter spark = new ExtentSparkReporter("//src/main/java/reports/TestResults.html");


        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/global.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String platform = (String) prop.get("platform");
        String appName = (String) prop.get("appName");
        String deviceName = (String) prop.get("deviceName");
        String platformVersion = (String) prop.get("platformVersion");
        String udid = (String) prop.get("udid");
        String packageName = (String) prop.get("packageName");
        String appActivityName = (String) prop.get("appActivityName");

//        File appDir = new File("src");
        File appDir = new File("src/main/resources/apps/");

        File app = new File(appDir, appName);


        if (platform.equalsIgnoreCase("Android")) {
            System.out.println("Platform :" + platform);
            System.out.println("AppName:" + appName);
            options.setPlatformName(platform);
            options.setDeviceName(deviceName); // Replace with your device name
            options.setPlatformVersion(platformVersion); // Replace with your Android version
            options.setUdid(udid);
            options.setAppPackage(packageName); // Replace with your app's package name
            options.setAppActivity(appActivityName); // Replace with your app's main activity
            options.setAutomationName("UiAutomator2");
            // options.setApp(app.getAbsolutePath());
        }

        if (platform.equalsIgnoreCase("iOS")) {
            System.out.println("Platform :" + platform);
            System.out.println("AppName:" + appName);
            options.setPlatformName(platform);
            options.setDeviceName(deviceName); // Replace with your device name
            options.setPlatformVersion(platformVersion); // Replace with your Android version
            options.setUdid(udid);
//        options.setAppPackage("com.example.app"); // Replace with your app's package name
//        options.setAppActivity("com.example.app.MainActivity"); // Replace with your app's main activity
            options.setAutomationName("XCUITest");
            options.setApp(app.getAbsolutePath());
        }
    }

    @BeforeMethod
    public void driverInitialisation(){
        // Initialize the driver
        try {
            URL serverURL = new URL("http://127.0.0.1:4723/");
            driver = new AppiumDriver(serverURL, options);
            System.out.println("Initialize the driver");

        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setupTest(Method method) {
        ExtentTest test = ExtentReportManager.getExtent().createTest(method.getName());
        ExtentReportManager.setTest(test);

        // Capture screenshot
        test.log(Status.PASS, "Test pass");
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "TestScreenshot");
       // test.addScreenCaptureFromPath(screenshotPath);
    }

    @Test
    public void test1() {
        System.out.println("Device connection established");
    }

//    @AfterMethod
//    public void closeApp(){
//        if (driver != null) {
//            driver.close();
//            ExtentReportManager.getTest().info("App closed after test execution.");
//        }    }

    @AfterSuite
    public void teardown(){
        // add log / report generation steps
        // Delete the unnecessary files/ data generated
        if(driver !=null){
            driver.quit();
        }
        ExtentReportManager.flushReport();
    }
}
