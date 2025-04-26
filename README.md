# Java Selenium TestNG Gradle POM Framework

This project is a Selenium-based test automation framework using Java, TestNG, and Gradle. It is designed for testing web applications with configurable browser support and reusable utilities.

## Prerequisites

Before running the project, ensure the following are installed and configured:

1. **Java Development Kit (JDK)**: Version 8 or higher.
    - Verify installation: `java -version`
2. **Gradle**: Version 7.0 or higher.
    - Verify installation: `gradle -v`
3. **Allure Command-Line Tool** (for generating test reports):
    - Install via Homebrew: `brew install allure`
    - Verify installation: `allure --version`
4. **Browser Drivers**: Managed automatically using WebDriverManager.

## Configuration

### Browser Configuration
The browser type can be specified dynamically using the `BROWSER_TYPE` property in the `ITestConfig` interface. By default, the browser is set to `firefox`. You can override this by passing the `-DBROWSER_TYPE` system property when running tests.

Example:
```java
String BROWSER_TYPE = System.getProperty("BROWSER_TYPE", "firefox");
```

To run tests with a specific browser (e.g., Chrome):
```bash
./gradlew smokeTests -DBROWSER_TYPE=chrome
```

### TestNG and Gradle Tasks
The `testng.xml` file and `build.gradle` contain redundant tasks for running tests (e.g., `smokeTests`, `regressionTests`, `allTests`). This redundancy is intentional to provide flexibility in running specific test groups.

- **TestNG**: Groups are defined in `testng.xml` for `SmokeTest` and `RegressionTest`.
- **Gradle Tasks**: Corresponding tasks (`smokeTests`, `regressionTests`, `allTests`) are defined in `build.gradle` for convenience.

## Running Tests

### Run All Tests
To run all tests:
```bash
./gradlew allTests
```

### Run Smoke Tests
To run only smoke tests:
```bash
./gradlew smokeTests
```

### Run Regression Tests
To run only regression tests:
```bash
./gradlew regressionTests
```

### Run Tests in Parallel
To run tests in parallel, configure the `testng.xml` file by adding the `parallel` attribute to the `<suite>` tag. For example:
```xml
<suite name="Parallel Suite" parallel="methods" thread-count="4">
```

Alternatively, you can configure parallel execution in `build.gradle`:
```groovy
test {
    useTestNG {
        parallel = 'methods'
        threadCount = 4
    }
}
```

## Generating Allure Reports

To generate and view Allure reports:
1. Run tests to generate results:
   ```bash
   ./gradlew allTests
   ```
2. Generate the Allure report:
   ```bash
   ./gradlew generateAllureReport
   ```
3. Open the Allure report in a browser:
   ```bash
   ./gradlew openAllureReport
   ```

## Project Structure

- `src/test/java/tests`: Contains test classes.
- `src/test/java/interfaces`: Contains configuration interfaces like `ITestConfig`.
- `src/test/java/utils`: Contains utility classes for browser management, screenshots, etc.
- `build.gradle`: Gradle build file with tasks for running tests and generating reports.
- `testng.xml`: TestNG configuration file for grouping and running tests.

## Notes

- The `maximizeWindow` logic is reused via `DriverUtils` for better maintainability.
- Implicit waits have been removed to encourage explicit waits for better test reliability.
- Ensure the `.gitignore` file excludes unnecessary files like `build/` and IDE-specific files.