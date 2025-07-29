package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LoggerUtility.startTest(this.getClass().getSimpleName());
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE)
        {
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        driver.quit();
        LoggerUtility.finishTest(this.getClass().getSimpleName());
    }

    public WebDriver getDriver() {
        return driver;
    }
}
