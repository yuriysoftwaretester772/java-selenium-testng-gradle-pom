package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.AmazonSearchPage;
import utils.ScreenshotUtils;

import java.util.concurrent.TimeUnit;

@Test(groups="RegressionTest")
public class SearchAmazonTest {
    private WebDriver driver;
    AmazonHomePage amazonHomePage;
    AmazonSearchPage amazonSearchPage;
    String searchItem = "nike airmax";

    @BeforeClass
    public void setUp() {
        driver = utils.BrowserFactory.getDriver(interfaces.ITestConfig.BROWSER_TYPE); // Get browser type dynamically
        utils.DriverUtils.maximizeWindow(driver);
        amazonHomePage = new AmazonHomePage(driver);
        amazonSearchPage = new AmazonSearchPage(driver);
    }

    @Test
    @Description("Open Amazon Home page, search for an item and check the title")
    public void openHomePageAndCheckTheTitle() {
        amazonHomePage.navigateToHomePage();
        amazonHomePage.verifyPageTitle();
        amazonHomePage.enterSearchItemAndSubmit(searchItem);
        amazonSearchPage.verifyPageTitle(searchItem);
    }

    @AfterClass
    public void tearDown() {
        ScreenshotUtils.screenshot(driver);
        driver.quit();
    }

}
