package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public class POC_Base {
    AppiumDriver driver;
    ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest test;
    AndroidDriver driver2;

    @BeforeSuite(groups = {"smoke"})
    public void frameworkBase() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/global.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String platform = (String) prop.get("platform");
        String appName = (String) prop.get("appName");
        String deviceName = (String) prop.get("deviceName");
        String platformVersion = (String) prop.get("platformVersion");
        String udid = (String) prop.get("udid");

//        File appDir = new File("src");
        File appDir = new File("src/main/resources/apps/");

        File app = new File(appDir, appName);

        UiAutomator2Options options = new UiAutomator2Options();

        if (platform.equalsIgnoreCase("Android")) {
            System.out.println("Platform :" + platform);
            System.out.println("AppName:" + appName);
            options.setPlatformName(platform);
            options.setDeviceName(deviceName); // Replace with your device name
            options.setPlatformVersion(platformVersion); // Replace with your Android version
            options.setUdid(udid);
//        options.setAppPackage("com.example.app"); // Replace with your app's package name
//        options.setAppActivity("com.example.app.MainActivity"); // Replace with your app's main activity
            options.setAutomationName("UiAutomator2");
            options.setApp(app.getAbsolutePath());
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

    @Test
    public void test1() {
        System.out.println("Device connection established");
    }


    @AfterSuite
    public void teardown(){
        // add log / report generation steps
        // Delete the unnecessary files/ data generated
        if(driver !=null){
            driver.quit();
        }
        extent.flush();
    }
}
