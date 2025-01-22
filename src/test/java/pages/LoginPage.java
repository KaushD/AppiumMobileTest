package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;


public class LoginPage {

    AppiumDriver driver;

    // Android Locators
    @FindBy(id = "com.yourcompany:id/username")
    private WebElement usernameField;

    @FindBy(xpath="//android.widget.TextView[@index=1]" )
    private WebElement androidPageTitle;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.apidemo:id/email_field\"]")
    private WebElement androidEnterEmail;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.apidemo:id/password_field\"]")
    private WebElement androidPassword;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Log in\"]")
    private WebElement androidLogin;

    //iOS Locators
    @FindBy(xpath="" )
    private WebElement iosPageTitle;

    @FindBy(xpath="" )
    private WebElement iosEnterEmail;

    @FindBy(xpath="" )
    private WebElement iosPassword;

    @FindBy(xpath="" )
    private WebElement iosLogin;


    // Constructor
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    private String getPlatformName() {
        return driver.getCapabilities().getCapability("platformName").toString();
    }

    public void verifyTitle(){
        WebElement pageTitle= getPlatformName().equalsIgnoreCase("Android")? androidPageTitle : iosPageTitle;
        String getHeaderText = androidPageTitle.getText().trim();
        Assert.assertEquals ("Please enter your log in details",getHeaderText);
    }

    public void enterEmail(String email){
        WebElement enterEmail= getPlatformName().equalsIgnoreCase("Android")? androidEnterEmail : iosEnterEmail;
        enterEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement enterPassword= getPlatformName().equalsIgnoreCase("Android")? androidPassword : iosPassword;
        enterPassword.sendKeys(password);
    }

    public void clickLogin(){
        WebElement login= getPlatformName().equalsIgnoreCase("Android")? androidLogin : iosLogin;
        login.click();
    }
}
