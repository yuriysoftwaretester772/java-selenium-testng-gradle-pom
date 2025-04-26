package tests;

import interfaces.ITestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;

public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        WebDriver webDriver = BrowserFactory.getDriver(ITestConfig.BROWSER_TYPE);
        webDriver.manage().window().maximize();
        driver.set(webDriver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    protected WebDriver getDriver() {
        return driver.get();
    }
}
