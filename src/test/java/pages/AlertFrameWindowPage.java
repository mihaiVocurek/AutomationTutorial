package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage {

    public AlertFrameWindowPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//span[text() = 'Alerts']")
    public WebElement alertsElement;
    @FindBy(xpath = "//span[text() = 'Frames']")
    public WebElement framesElement;
    @FindBy(xpath = "//span[text() = 'Browser Windows']")
    public WebElement elementBrowserWindows;

    public void interactWithAlertsSubmenu(){
        elementHelper.clickJSElement(alertsElement);
    }

    public void interactWithFrameSubmenu(){
        elementHelper.clickJSElement(framesElement);
    }

    public void interactWithWindowsSubmenu(){
        elementHelper.clickJSElement(elementBrowserWindows);
    }
}
