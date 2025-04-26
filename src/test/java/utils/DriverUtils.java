package utils;

import org.openqa.selenium.WebDriver;

public class DriverUtils {
    public static void maximizeWindow(WebDriver driver) {
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }
}