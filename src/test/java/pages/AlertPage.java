package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "alertButton")
    public WebElement alertOkButtonElement;
    @FindBy(id = "timerAlertButton")
    public WebElement alertWaitButtonElement;
    @FindBy(id = "confirmButton")
    public WebElement alertOkCancelElement;
    @FindBy(id = "promtButton")
    public WebElement alertWithTextElement;

    public void dealAlertOk(){
        elementHelper.clickJSElement(alertOkButtonElement);
        alertHelper.acceptAlert();
    }

    public void dealAlertTimer(){
        elementHelper.clickJSElement(alertWaitButtonElement);
        alertHelper.acceptAlert();
        pageHelper.scrollPage(0,400);
    }

    public void dealAlertCancel(){
        elementHelper.clickJSElement(alertOkCancelElement);
        alertHelper.dismissAlert();
    }

    public void dealAlertPrompt(String value){
        elementHelper.clickJSElement(alertWithTextElement);
        alertHelper.fillAlert(value);
    }
}
