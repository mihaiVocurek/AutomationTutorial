package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage {

    public AlertFrameWindowPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//span[text() = 'Alerts']")
    private WebElement alertsElement;
    @FindBy(xpath = "//span[text() = 'Frames']")
    private WebElement framesElement;
    @FindBy(xpath = "//span[text() = 'Browser Windows']")
    private WebElement elementBrowserWindows;

    public void interactWithAlertsSubmenu(){
        elementHelper.clickJSElement(alertsElement);
        LoggerUtility.infoLog("User clicks on Alerts submenu");
    }

    public void interactWithFrameSubmenu(){

        elementHelper.clickJSElement(framesElement);
        LoggerUtility.infoLog("User clicks on Frames submenu");
    }

    public void interactWithWindowsSubmenu(){

        elementHelper.clickJSElement(elementBrowserWindows);
        LoggerUtility.infoLog("User clicks on Windows submenu");
    }
}
