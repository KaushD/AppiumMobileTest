package pages;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScreenshotUtil;

import java.time.Duration;

public class LaunchPage {
    AppiumDriver driver = null;

    public LaunchPage(AppiumDriver driver) {
        this.driver = driver;
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    //Android Locators
    @FindBy(xpath = "//android.widget.Button[@text=\"Create an account\"]")
    private WebElement androidCreateAccount;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Log in\"]")
    private WebElement androidLoginWithEmail;



    //iOS Locators - to be updated
    @FindBy(xpath = "//android.widget.TextView[@text=\"Log in\"]")
    private WebElement iosLoginWithEmail;



    // Android Locators
    //pageTitle
    //description



    private String getPlatformName() {
        return driver.getCapabilities().getCapability("platformName").toString();
    }

    //Actions
    public void clickLoginWithEmail() {

//         1. Working
//          driver.findElement(By.xpath("//android.widget.TextView[@text=\"Log in with email\"]")).click();

      //2. Working
      //  androidLoginWithEmail.click();

// 3. working
        WebElement loginWithEmail= getPlatformName().equalsIgnoreCase("Android")? androidLoginWithEmail : iosLoginWithEmail;
        loginWithEmail.click();
        System.out.println("Logged in with Email");

        test.log(Status.PASS, "Landed on user registration screen");
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "TestScreenshot");
        test.addScreenCaptureFromPath(screenshotPath);
    }


}