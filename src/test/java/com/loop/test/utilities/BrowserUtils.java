package com.loop.test.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class BrowserUtils {
    /**
     * validate if driver switch to expected url and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @autor sergii
     * inmplement assertion
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set <String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     *
     * switches to the new window bu the exact title
     * return to original window if the window with given title not found
     * @param driver
     * @param  targetTitle
     */


    public static  void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for (String handel:driver.getWindowHandles()){
            driver.switchTo().window(handel);
            if (driver.getTitle().contains(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);

    }
}
