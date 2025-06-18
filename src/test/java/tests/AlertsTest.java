package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {
    public WebDriver driver;

    @Test
    public void testMethod() {
        driver = new ChromeDriver();
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertsFramesWindowsMenu = driver.findElement(By.xpath("//h5[text() = 'Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();", alertsFramesWindowsMenu);

        WebElement alertsElement = driver.findElement(By.xpath("//span[text() = 'Alerts']"));
        executor.executeScript("arguments[0].click();", alertsElement);

        WebElement alertOkButtonElement = driver.findElement(By.id("alertButton"));
        executor.executeScript("arguments[0].click();", alertOkButtonElement);

        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        WebElement alertWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        executor.executeScript("arguments[0].click();", alertWaitButtonElement);

        //Wait explicit pentru alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertWait = driver.switchTo().alert();
        alertWait.accept();

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        executor.executeScript("arguments[0].click();", alertOkCancelElement);

        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();

        WebElement alertWithTextElement = driver.findElement(By.id("promtButton"));
        executor.executeScript("arguments[0].click();", alertWithTextElement);

        Alert alertWithText = driver.switchTo().alert();
        alertWithText.sendKeys("ceva test");
        alertWithText.accept();

        driver.quit();

    }

}
