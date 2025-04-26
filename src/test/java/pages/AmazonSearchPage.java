package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import interfaces.ITestConfig;

public class AmazonSearchPage extends BasePage implements ITestConfig {

    private static final String PAGE_TITLE = "Amazon.com : ";
    private static final String PAGE_URL = "https://www.amazon.com/s?k=";

    private static final By SEARCH_INPUT_FIELD = By.id("twotabsearchtextbox");
    private static final By SEARCH_BUTTON = By.id("nav-search-submit-button");

    public AmazonSearchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToSearchPage(String item) {
        navigateTo(PAGE_URL + item);
    }

    public void clearSearchInputField() {
        driver.findElement(SEARCH_INPUT_FIELD).clear();
    }

    public void enterSearchItemAndSubmit(String item) {
        driver.findElement(SEARCH_INPUT_FIELD).sendKeys(item);
        driver.findElement(SEARCH_BUTTON).click();
    }

    public void verifyPageTitle(String searchItem) {
        String actualTitle = getPageTitle().toLowerCase();
        String searchItemLower = searchItem.toLowerCase();

        Assert.assertTrue(actualTitle.contains(searchItemLower),
                String.format("Page title '%s' does not contain search term '%s'", actualTitle, searchItem));
    }
}