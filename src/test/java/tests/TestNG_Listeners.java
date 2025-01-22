package tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

// ITestListeners in interface which implements TestNG Listeners
public class TestNG_Listeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        // Screenshot or a Pass message
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //Screenshot & a Failure message
        //If API failed, then capture the response
        System.out.println("Failed Test case name :"+result.getName());
    }
}
