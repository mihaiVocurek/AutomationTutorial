package helperMethods;

import org.openqa.selenium.*;

public class ElementHelper {

    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJSElement(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void printTextElement(WebElement element){
        System.out.println(element.getText());
    }

    public void fillElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public void pressElement(WebElement element, Keys keyValue){
        element.sendKeys(keyValue);
    }

    public void clearElement(WebElement element){
        element.clear();
    }

}
