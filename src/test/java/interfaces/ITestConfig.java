package interfaces;

public interface ITestConfig {
    // Browser configuration
    String BROWSER_TYPE = System.getProperty("BROWSER_TYPE", "firefox");
    long IMPLICIT_WAIT = 10L;
    long EXPLICIT_WAIT = 20L;

    // Base URLs (with system property support if needed later)
    String BASE_URL = System.getProperty("BASE_URL", "https://www.amazon.com");
    String SEARCH_URL = BASE_URL + "/s?k=";

    // Test data file paths
    String EXCEL_PATH = "src/test/resources/testdata/";
    String SCREENSHOTS_PATH = "test-output/screenshots/";

    // Common page titles and messages
    String HOME_PAGE_TITLE = "Amazon.com. Spend less. Smile more.";
    String TITLE_ERROR_MESSAGE = "Page title does not match";
    String URL_ERROR_MESSAGE = "URL does not match";
}
