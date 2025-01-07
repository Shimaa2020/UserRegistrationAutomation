import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeClass
    public void setup() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/reports/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/");
        test = extent.createTest("Setup Test Environment");
        test.info("Browser launched and navigated to: https://automationexercise.com/");
    }

    @AfterMethod
    public void logResults(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test skipped");
        }
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }
}