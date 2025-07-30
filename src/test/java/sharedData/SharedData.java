package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;
    private String browser;

    @BeforeMethod
    public void prepareEnvironment(){
        LoggerUtility.startTest(this.getClass().getSimpleName());

        browser = "Edge";

        switch (browser){
            case "Chrome":
                ChromeBrowser chromeBrowser = new ChromeBrowser();
                chromeBrowser.openBrowser();
                driver = chromeBrowser.getDriver();
                break;
            case "Edge":
                EdgeBrowser edgeBrowser = new EdgeBrowser();
                edgeBrowser.openBrowser();
                driver = edgeBrowser.getDriver();
                break;
        }

        LoggerUtility.infoLog("The browser " + browser + " was opened with success");
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE)
        {
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        driver.quit();

        LoggerUtility.infoLog("The browser " + browser + " was closed with success");

        LoggerUtility.finishTest(this.getClass().getSimpleName());
    }

    public WebDriver getDriver() {
        return driver;
    }
}
