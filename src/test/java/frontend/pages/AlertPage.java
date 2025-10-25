package frontend.pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertOkButtonElement;
    @FindBy(id = "timerAlertButton")
    private WebElement alertWaitButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement alertOkCancelElement;
    @FindBy(id = "promtButton")
    private WebElement alertWithTextElement;

    public void dealAlertOk(){
        elementHelper.clickJSElement(alertOkButtonElement);
        LoggerUtility.infoLog("User clicks on Alert OK button");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("User deals with Alert OK presence");
    }

    public void dealAlertTimer(){
        elementHelper.clickJSElement(alertWaitButtonElement);
        LoggerUtility.infoLog("User clicks on Alert Timer button");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("User deals with Alert OK presence");
        pageHelper.scrollPage(0,400);
        LoggerUtility.infoLog("User scrolls down the page");
    }

    public void dealAlertCancel(){
        elementHelper.clickJSElement(alertOkCancelElement);
        LoggerUtility.infoLog("User clicks on Alert Cancel button");
        alertHelper.dismissAlert();
        LoggerUtility.infoLog("User cancels alert");
    }

    public void dealAlertPrompt(String value){
        elementHelper.clickJSElement(alertWithTextElement);
        LoggerUtility.infoLog("User clicks on Alert prompt");
        alertHelper.fillAlert(value);
        LoggerUtility.infoLog("User fills the alert with the value: "+value);
    }
}
