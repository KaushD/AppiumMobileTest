package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Map;

public class ScanQRcodeUtil {

    AppiumDriver driver = null;

    public void ScanQRcodeUtil(AppiumDriver driver) {
        this.driver = driver;
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    public void scanQRcode(String urlValue){
    // Simulate QR code scan via deep linking (Mocked Data)
            driver.executeScript("mobile: deepLink", Map.of(
                    "url", urlValue
//                    "package", "com.example"
                    ));
}
}

