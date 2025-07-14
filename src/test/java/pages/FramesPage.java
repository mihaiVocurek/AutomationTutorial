package pages;

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
    public WebElement firstBlockElement;
    @FindBy(id = "sampleHeading")
    public WebElement secondBlockElement;

    public void dealWithBigIFrame(){
        frameHelper.switchFrameByElement(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        elementHelper.printTextElement(firstBlockElement);
        frameHelper.switchToParent();
    }

    public void dealWithLittleIFrame(){
        frameHelper.switchFrameByString("frame2");
        elementHelper.printTextElement(secondBlockElement);
        frameHelper.switchToParent();
    }
}
