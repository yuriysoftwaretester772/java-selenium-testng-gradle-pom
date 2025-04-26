package pages;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import interfaces.ITestConfig;


public class AmazonHomePage extends BasePage implements ITestConfig {

    private static final String PAGE_TITLE = "Amazon.com. Spend less. Smile more.";
    private static final String PAGE_URL = "https://www.amazon.com";

    private static final By SEARCH_INPUT_FIELD = By.id("twotabsearchtextbox");
    private static final By SEARCH_BUTTON = By.id("nav-search-submit-button");

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        navigateTo(PAGE_URL);
    }

    public void verifyPageTitle() {
        Assert.assertEquals(getPageTitle(), PAGE_TITLE, "Page title does not match.");
    }

    public void waitForSearchBox(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ITestConfig.EXPLICIT_WAIT));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
    }

    public void enterSearchItemAndSubmit(String item) {
        driver.findElement(SEARCH_INPUT_FIELD).sendKeys(item);
        driver.findElement(SEARCH_BUTTON).click();
    }

}
