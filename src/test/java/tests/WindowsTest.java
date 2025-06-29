package tests;

import helperMethods.ElementHelper;
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

        ElementHelper elementHelper = new ElementHelper(driver);

        WebElement alertsFramesWindowsMenu = driver.findElement(By.xpath("//h5[text() = 'Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(alertsFramesWindowsMenu);

        WebElement browserWindowSubmenu = driver.findElement(By.xpath("//span[text() = 'Browser Windows']"));
        elementHelper.clickJSElement(browserWindowSubmenu);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        elementHelper.clickJSElement(newTabButton);

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
        elementHelper.clickJSElement(newWindowButton);

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(windowList.get(0));
        System.out.println(driver.getCurrentUrl());

/*
        //merge doar in Firefox
        WebElement newWindowsMessageButton = driver.findElement(By.id("messageWindowButton"));
        elementHelper.clickJSElement(newWindowsMessageButton);

        List<String> messageWindowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(messageWindowList.get(1));
        WebElement textBody = driver.findElement(By.xpath("//body"));
        System.out.println(textBody.getText());
        driver.switchTo().window(messageWindowList.get(0));
        System.out.println(driver.getCurrentUrl());
 */
    }
}
