package tests;

import helperMethods.ElementHelper;
import sharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);

        WebElement alertsFramesWindowsMenu = driver.findElement(By.xpath("//h5[text() = 'Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(alertsFramesWindowsMenu);

        WebElement framesElement = driver.findElement(By.xpath("//span[text() = 'Frames']"));
        elementHelper.clickJSElement(framesElement);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        //driver.switchTo().frame("frame1");

        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(firstBlockElement.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");

        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondBlockElement);

        driver.switchTo().parentFrame();

    }
}
