package frontend.pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement firstBlockElement;
    @FindBy(id = "sampleHeading")
    private WebElement secondBlockElement;

    public void dealWithBigIFrame(){
        frameHelper.switchFrameByElement(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        LoggerUtility.infoLog("The user switches to specific frame");
        elementHelper.printTextElement(firstBlockElement);
        frameHelper.switchToParent();
        LoggerUtility.infoLog("The user switches to parent frame");
    }

    public void dealWithLittleIFrame(){
        frameHelper.switchFrameByString("frame2");
        LoggerUtility.infoLog("The user switches to specific frame");
        elementHelper.printTextElement(secondBlockElement);
        frameHelper.switchToParent();
        LoggerUtility.infoLog("The user switches to parent frame");
    }
}
