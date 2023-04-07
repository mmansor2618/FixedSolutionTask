package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.time.Duration;

import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest logger;

    Properties prop;
    String CurrentPath = System.getProperty("user.dir");
    FileInputStream fis;


    @BeforeSuite
    public void setup() throws Exception{
        String  browser="chrome";

        extent = new ExtentReports("extentReport.html", true);

        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            //create chrome instance
            driver = new ChromeDriver();

        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("edge")){
            //set path to Edge.exe
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\edgedriver.exe");
            //create Edge instance
            driver = new EdgeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void results(Method method, ITestResult result) throws Exception {
        // test new commit
        if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "Test Passed");
            String screenshotPath = Utils.getScreenShot(driver, result.getName());
            logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
            String screenshotPath = Utils.getScreenShot(driver, result.getName());
            logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
        } else {
            logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        }
    }

    @BeforeMethod
    void SetUp(Method method) throws IOException{
        logger = extent.startTest(method.getName());
        readData();
    }

    private void readData() throws IOException {
        prop= new Properties();
        String CurrentPath = System.getProperty("user.dir");
        fis=new FileInputStream(CurrentPath + "/src/Data/crud.properties");
        prop.load(fis);
    }

    @AfterSuite
    public void tearDown() {

        extent.flush();
        driver.get(System.getProperty("user.dir") + "\\extentReport.html");

//		driver.close();

    }

}