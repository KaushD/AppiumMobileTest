package tests;

import org.testng.annotations.Test;
import pages.AccessibilityNodeProviderPage;
import pages.AccessibilityPage;
import pages.LaunchPage;

public class AccessibilityTest extends BaseClass {

    private LaunchPage launchPage =new LaunchPage(driver);
    private AccessibilityPage accessibilityPage = new AccessibilityPage(driver);
    private AccessibilityNodeProviderPage nodeProvider = new AccessibilityNodeProviderPage(driver);

    @Test (groups = {"regression"})
    public void validateAccessibility(){
        launchPage = new LaunchPage(driver);
        accessibilityPage = new AccessibilityPage(driver);
        System.out.println("Launch Page");
        launchPage.clickAccessibility();
        accessibilityPage.validateAccessibility1();
    }

    @Test (groups = {"regression"})
    public void validateNodeProvider(){
        accessibilityPage.clickAccessibility1();
        nodeProvider.validatePageContent();
    }


}
