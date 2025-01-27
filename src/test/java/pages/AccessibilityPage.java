package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;


public class AccessibilityPage {

    AppiumDriver driver;

    // Android Locators
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Accessibility Node Provider\"]")
    private WebElement androidAccessibilityOption1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Accessibility Node Querying\"]")
    private WebElement accessibilityOption2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Accessibility Service\"]")
    private WebElement accessibilityOption3;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Custom View\"]")
    private WebElement accessibilityOption4;


    //iOS Locators
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Accessibility Node Provider\"]")
    private WebElement iosAccessibilityOption1;
    @FindBy(xpath="" )
    private WebElement iosPageTitle;

    @FindBy(xpath="" )
    private WebElement iosEnterEmail;

    @FindBy(xpath="" )
    private WebElement iosPassword;

    @FindBy(xpath="" )
    private WebElement iosLogin;


    // Constructor
    public AccessibilityPage(AppiumDriver driver) {
        this.driver = driver;
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    private String getPlatformName() {
        return driver.getCapabilities().getCapability("platformName").toString();
    }

    public void validateAccessibility1(){
           WebElement accessibility = getPlatformName().equalsIgnoreCase("Android")? androidAccessibilityOption1 : iosAccessibilityOption1;
                Assert.assertEquals (accessibility.getText(),"Accessibility Node Provider");
    }

    public void clickAccessibility1(){
        WebElement accessibility = getPlatformName().equalsIgnoreCase("Android")? androidAccessibilityOption1 : iosAccessibilityOption1;
        accessibility.click();
        //Assert.assertEquals (accessibility.getText(),"Accessibility Node Provider");

    }

//    public void verifyTitle(){
//        WebElement pageTitle= getPlatformName().equalsIgnoreCase("Android")? androidPageTitle : iosPageTitle;
//        String getHeaderText = androidPageTitle.getText().trim();
//        Assert.assertEquals ("Please enter your log in details",getHeaderText);
//    }

//    public void enterEmail(String email){
//        WebElement enterEmail= getPlatformName().equalsIgnoreCase("Android")? androidEnterEmail : iosEnterEmail;
//        enterEmail.sendKeys(email);
//    }
//
//    public void enterPassword(String password){
//        WebElement enterPassword= getPlatformName().equalsIgnoreCase("Android")? androidPassword : iosPassword;
//        enterPassword.sendKeys(password);
//    }
//
//    public void clickLogin(){
//        WebElement login= getPlatformName().equalsIgnoreCase("Android")? androidLogin : iosLogin;
//        login.click();
//    }
}
