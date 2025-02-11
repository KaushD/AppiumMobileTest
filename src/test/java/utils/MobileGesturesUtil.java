package utils;

import com.beust.ah.A;
import com.sun.jna.platform.win32.Wevtapi;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class MobileGesturesUtil {
    AppiumDriver driver = null;

    public MobileGesturesUtil(AppiumDriver driver) {
        this.driver = driver;
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    //Tap the center of an element - using Coordinates
    public void tap(AppiumDriver driver, WebElement element){
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point centerOfElement = getCenterOfElement(location, size);

        PointerInput tap1 = new PointerInput(PointerInput.Kind.TOUCH, "tap1");
        Sequence sequence = new Sequence(tap1, 1)
                .addAction(tap1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(tap1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(tap1, Duration.ofMillis(200)))
                .addAction(tap1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }


    // Long Press
    public void longPress (AppiumDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point centerOfElement = getCenterOfElement(location, size);
        PointerInput touch1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");
        Sequence sequence = new Sequence(touch1, 1)
                .addAction(touch1.createPointerMove (Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(touch1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//waiting for 2 seconds for longPress on the Element
                .addAction(new Pause(touch1, Duration.ofSeconds(2)))
                .addAction(touch1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    //Scroll to a given point on the screen
       public void scrollDown(AppiumDriver driver){
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);
        PointerInput touch1 = new PointerInput (PointerInput.Kind. TOUCH,"touch1");
        Sequence sequence= new Sequence(touch1,1)
                .addAction (touch1.createPointerMove (Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction (touch1.createPointerDown (PointerInput.MouseButton. LEFT.asArg()))
                .addAction (new Pause (touch1, Duration.ofMillis(200)))
                .addAction(touch1.createPointerMove (Duration.ofMillis(100), PointerInput. Origin.viewport(), endX, endY))
                .addAction (touch1.createPointerUp (PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    public void scrollUntilElementVisible(AppiumDriver driver, String target) {
        int maxScrolls = 5;
        int attempts = 0;
        while (attempts < maxScrolls) {
            try {
                if (driver.findElement(By.xpath(target)).isDisplayed()) {
                    System.out.println("Element found!");
                    break;
                }
            } catch (Exception e) {
                scrollDown(driver);
            }
            attempts++;
        }
    }

    //Swipe : With coordinates of Start & End positions
    public void swipe(AppiumDriver driver){
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = (int)(size.getWidth() * 0.25);
        int endY = startY;
        PointerInput touch1 = new PointerInput (PointerInput.Kind. TOUCH,"touch1");
        Sequence sequence= new Sequence(touch1,1)
                .addAction (touch1.createPointerMove (Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction (touch1.createPointerDown(PointerInput.MouseButton. LEFT.asArg()))
                .addAction (new Pause (touch1, Duration.ofMillis(200)))
                .addAction(touch1.createPointerMove (Duration.ofMillis(100), PointerInput. Origin.viewport(), endX, endY))
                .addAction (touch1.createPointerUp (PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }



    // Drag & Drop
    public void dragAndDrop(AppiumDriver driver, WebElement source, WebElement target){
//        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
//        WebElement target = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));
        Point sourceElementCenter = getCenterOfElement(source.getLocation(), source.getSize());
        Point targetElementCenter = getCenterOfElement(target.getLocation(), target.getSize());
        PointerInput touch1 = new PointerInput (PointerInput.Kind. TOUCH,"touch1");
        Sequence sequence = new Sequence (touch1, 1)
                .addAction (touch1.createPointerMove (Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
                .addAction (touch1.createPointerDown(PointerInput.MouseButton. LEFT.asArg()))
                .addAction(new Pause(touch1, Duration.ofMillis(588)))
                .addAction(touch1.createPointerMove(Duration.ofMillis(588), PointerInput.Origin.viewport(), targetElementCenter))
                .addAction (touch1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    //Pinch or Zoom
    public void pinchOrZoom(AppiumDriver driver, WebElement elem){
        Point centerOfElement = getCenterOfElement(elem.getLocation(), elem.getSize());
        PointerInput touch1 = new PointerInput (PointerInput.Kind. TOUCH, "touch1");
        PointerInput finger2 = new PointerInput (PointerInput.Kind. TOUCH, "finger2");
        Sequence sequence = new Sequence(touch1,1)
                .addAction(touch1.createPointerMove (Duration. ZERO, PointerInput. Origin.viewport(), centerOfElement))
                .addAction (touch1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause (touch1, Duration.ofMillis(288)))
                .addAction(touch1.createPointerMove (Duration.ofMillis(208),
                        PointerInput.Origin.viewport(),
                        centerOfElement.getX() + 100,
                        centerOfElement.getY()- 100))
                .addAction (touch1.createPointerUp (PointerInput.MouseButton.LEFT.asArg()));
        Sequence sequence2 = new Sequence(finger2,1)
                .addAction (finger2.createPointerMove(Duration.ZERO, PointerInput. Origin.viewport(), centerOfElement))
                .addAction (finger2.createPointerDown(PointerInput.MouseButton. LEFT.asArg()))
                .addAction(new Pause (finger2, Duration.ofMillis(200)))
                .addAction (finger2.createPointerMove(Duration.ofMillis(200),
                        PointerInput.Origin.viewport(),
                        centerOfElement.getX()-100,
                        centerOfElement.getY()+ 100))
                .addAction (finger2.createPointerUp(PointerInput. MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence,sequence2));
    }

    //find the center of an element
    private Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth()/2,
                location.getY()+ size.getHeight()/2);
    }
}
