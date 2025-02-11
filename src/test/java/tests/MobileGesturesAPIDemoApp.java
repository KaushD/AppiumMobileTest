package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MobileGesturesUtil;


// This class contains all the test cases for Mobile Gestures. All the Gesture implementations are created inside MobileGestureUtil class.
public class MobileGesturesAPIDemoApp extends BaseClass {


 MobileGesturesUtil gesture = new MobileGesturesUtil(driver);

    @Test
       private void longPress(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        WebElement tapElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Expandable Lists\"]\n"));
        gesture.tap(driver,tapElement);
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"1. Custom Adapter\"]")).click();
        WebElement longPressElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
       gesture.longPress(driver,longPressElement);
        System.out.println(driver.findElement(By.id("android:id/title")).isDisplayed());
    }

    @Test
    private void dragAndDropClock(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Date Widgets\"]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"2. Inline\"]")).click();
        System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text=\"Views/Date Widgets/2. Inline\"]")).isDisplayed());

        //Click 9
        driver.findElement(By.xpath("//*[@content-desc=\"9\"]")).click();

        //drag & drop the timing
        WebElement source = driver.findElement(By.xpath("//*[@content-desc=\"15\"]"));
        WebElement target = driver.findElement(By.xpath("//*[@content-desc=\"35\"]"));
        gesture.dragAndDrop(driver,source,target);
        //Should display 9.35 after selecting the time
        System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/hours\" and @text=\"9\"]")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/minutes\" and @text=\"35\"]")).isDisplayed());
    }


@Test
    private void scrollUntilElementVisible(){
    driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
    System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='Auto Complete']")).isDisplayed());
// Pass the xpath for the element
    String xpathOfTarget = "//android.widget.TextView[@text=\"WebView\"]";
    gesture.scrollUntilElementVisible(driver,xpathOfTarget);
}

@Test
    private void dragAndDropElements(){
    driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
    driver.findElement(By.xpath("//android.widget.TextView[@text=\"Drag and Drop\"]")).click();
    System.out.println("Navigated to the Drag & Drop page : "+driver.findElement(By.xpath("//android.widget.TextView[@text=\"Views/Drag and Drop\"]")).isDisplayed());

//    WebElement drag = driver.findElement(By.xpath(""));
//    WebElement drop = driver.findElement(By.xpath(""));

    WebElement drag = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
    WebElement drop = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
    gesture.dragAndDrop(driver,drag,drop);
    System.out.println("Drop completed : "+driver.findElement(By.xpath("//android.widget.TextView[@text='Dropped!']")).isDisplayed());


//Set the assertion as fail
//    WebElement validation = driver.findElement(By.xpath("//android.widget.TextView[@text='Dropped!']"));
//    Assert.assertEquals (validation.getText(),"Dropped abc");
    }

}
