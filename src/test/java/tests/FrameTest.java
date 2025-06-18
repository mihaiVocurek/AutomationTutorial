package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest {

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

        WebElement framesElement = driver.findElement(By.xpath("//span[text() = 'Frames']"));
        executor.executeScript("arguments[0].click();", framesElement);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        //driver.switchTo().frame("frame1");

        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(firstBlockElement.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");

        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondBlockElement);

        driver.switchTo().parentFrame();

        driver.quit();

    }
}
