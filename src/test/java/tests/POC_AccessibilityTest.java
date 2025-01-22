package tests;

import org.testng.annotations.Test;
import pages.AccessibilityPage;
import pages.LaunchPage;

public class POC_AccessibilityTest extends POC_Base {

    private LaunchPage launchPage =new LaunchPage(driver);
    private AccessibilityPage accessibilityPage = new AccessibilityPage(driver);

    @Test (groups = {"smoke"})
    public void validateAccessibility(){
        launchPage = new LaunchPage(driver);
        accessibilityPage = new AccessibilityPage(driver);
        System.out.println("Launch Page");
        launchPage.clickAccessibility();
        accessibilityPage.validateAccessibility1();
//        accessibilityPage.enterEmail("test2@yopmail.com");
//        accessibilityPage.enterPassword("test12345");
//        accessibilityPage.clickLogin();
    }


}
