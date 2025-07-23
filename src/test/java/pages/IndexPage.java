package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//h5[text() = 'Alerts, Frame & Windows']")
    private WebElement elementAlertsFrameWindows;
    @FindBy(xpath = "//h5[text() = 'Elements']")
    private WebElement elementsMenu;
    @FindBy(xpath = "//h5[text() = 'Forms']")
    private WebElement formsMenu;

    public void interactWithAlertsFrameWindowMenu(){
        elementHelper.clickJSElement(elementAlertsFrameWindows);
    }

    public void interactWithElementsMenu(){
        elementHelper.clickJSElement(elementsMenu);
    }

    public void interactWithFormsMenu(){
        elementHelper.clickJSElement(formsMenu);
    }


}
