package tests;

import sharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends SharedData {

    @Test
    public void testMethod(){

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement alertsFramesWindowsMenu = driver.findElement(By.xpath("//h5[text() = 'Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();", alertsFramesWindowsMenu);

        WebElement browserWindowSubmenu = driver.findElement(By.xpath("//span[text() = 'Browser Windows']"));
        executor.executeScript("arguments[0].click();", browserWindowSubmenu);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        executor.executeScript("arguments[0].click();", newTabButton);

        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));
        System.out.println(driver.getCurrentUrl());

        //inchide tab-ul pe care sunt
        driver.close();

        driver.switchTo().window(tabsList.get(0));
        System.out.println(driver.getCurrentUrl());

        //din cauze reclamei , fortam site-ul sa acceseze un URL specific
        //driver.navigate().to("https://demoqa.com/browser-windows");

        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        executor.executeScript("arguments[0].click();", newWindowButton);

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(windowList.get(0));
        System.out.println(driver.getCurrentUrl());


        WebElement newWindowsMessageButton = driver.findElement(By.id("messageWindowButton"));
        executor.executeScript("arguments[0].click();", newWindowsMessageButton);

        List<String> messageWindowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(messageWindowList.get(1));
        WebElement textBody = driver.findElement(By.xpath("//body"));
        System.out.println(textBody.getText());
        driver.switchTo().window(messageWindowList.get(0));
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}
