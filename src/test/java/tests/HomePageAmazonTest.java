package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import utils.ScreenshotUtils;
import utils.DriverUtils;

import java.util.concurrent.TimeUnit;

@Test(groups="SmokeTest")
public class HomePageAmazonTest {
    private WebDriver driver;
    AmazonHomePage amazonHomePage;

    @BeforeClass
    public void setUp() {
        driver = utils.BrowserFactory.getDriver(interfaces.ITestConfig.BROWSER_TYPE); // Get browser type dynamically
        utils.DriverUtils.maximizeWindow(driver);
        amazonHomePage = new AmazonHomePage(driver);
    }

    @Test
    @Description("Open Amazon Home page and check the title")
    public void openHomePageAndCheckTheTitle() {
        amazonHomePage.navigateToHomePage();
        amazonHomePage.verifyPageTitle();
    }

    @AfterClass
    public void tearDown() {
        ScreenshotUtils.screenshot(driver);
        driver.quit();
    }
}
