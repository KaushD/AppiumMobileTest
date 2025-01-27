package pages;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import utils.ScreenshotUtil;

import java.time.Duration;

public class LaunchPage {
    AppiumDriver driver = null;

    public LaunchPage(AppiumDriver driver) {
        this.driver = driver;
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    //Android Locators
    @FindBy(xpath = "//android.widget.TextView[@text=\"Accessibility\"]")
    private WebElement androidAccessibility;

    @FindBy(xpath = "//android.widget.TextView[@text=\"App\"]")
    private WebElement androidLoginWithEmail;

    //iOS Locators - to be updated
    @FindBy(xpath = "//android.widget.TextView[@text=\"Accessibility\"]\n")
    private WebElement iosAccessibility;



    private String getPlatformName() {
        return driver.getCapabilities().getCapability("platformName").toString();
    }

    //Actions
    public void clickAccessibility() {

//         1. Working
//          driver.findElement(By.xpath("//android.widget.TextView[@text=\"Log in with email\"]")).click();

      //2. Working
      //  androidLoginWithEmail.click();

// 3. working
        WebElement accessibility= getPlatformName().equalsIgnoreCase("Android")? androidAccessibility : iosAccessibility;
        accessibility.click();
       // System.out.println("Navigated to the Accessibility screen");

//        test.log(Status.PASS, "Landed on user registration screen");
//        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "TestScreenshot");
//        test.addScreenCaptureFromPath(screenshotPath);
    }


}