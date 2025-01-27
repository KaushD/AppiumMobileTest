package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class AccessibilityNodeProviderPage {

    AppiumDriver driver;

    //Android Locators
    @FindBy(xpath = "//android.widget.TextView[contains(@text,\"Enable TalkBack and Explore\")]")
    private WebElement androidAccessibilityDescription;

    //iOS Locators
    @FindBy(xpath = "//android.widget.TextView[contains(@text,\"Enable TalkBack and Explore\")]")
    private WebElement iOSAccessibilityDescription;

    public AccessibilityNodeProviderPage(AppiumDriver driver) {
        this.driver = driver;
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    private String getPlatformName() {
        return driver.getCapabilities().getCapability("platformName").toString();
    }

    public void validatePageContent(){
        WebElement accessibility = getPlatformName().equalsIgnoreCase("Android")? androidAccessibilityDescription : iOSAccessibilityDescription;
        Assert.assertEquals (accessibility.getText(),"Enable TalkBack and Explore");
    }

}
