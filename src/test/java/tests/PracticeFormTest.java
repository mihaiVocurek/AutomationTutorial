package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.*;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void testMethod() {
        //Deschidem o instanta de Chrome
        driver = new EdgeDriver();
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        //Accesam o pagina specifica
        driver.get("https://demoqa.com/");

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text() = 'Forms']"));
        executor.executeScript("arguments[0].click();", formsMenu);

        WebElement practiceFormSubmenu = driver.findElement(By.xpath("//span[text() = 'Practice Form']"));
        executor.executeScript("arguments[0].click();", practiceFormSubmenu);

        //Facem browser-ul sa fie in modul maximize
        driver.manage().window().maximize();

        //wait implicit
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identificam un element
        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        firstNameElement.sendKeys("Gigel");

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        lastNameElement.sendKeys("Banel");

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        emailElement.sendKeys("gigel.banel@email.com");

        WebElement mobileNoElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        mobileNoElement.sendKeys("22222222222");

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "Arts");
        for(int index = 0; index<subjectValues.size(); index++){
            subjectsElement.sendKeys(subjectValues.get(index));
            subjectsElement.sendKeys(Keys.ENTER);
        }

        String genderValue = "Male";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id = 'genterWrapper'] label[class='custom-control-label']"));
        switch (genderValue){
            case "Male":
                genderElementList.get(0).click();
                break;
            case "Female":
                genderElementList.get(1).click();
                break;
            case "Other":
                genderElementList.get(2).click();
                break;
            default:
                System.out.println("Gender is not available");
        }

        //pt a da scroll in jos (daca valoare pozitiva , atunci face scroll la dr sau in jos)
        executor.executeScript("window.scrollBy(0,200)","");
        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id = 'hobbiesWrapper'] label[class='custom-control-label']"));
        List<String> hobbyValues = Arrays.asList("Reading", "Music");
        for(int index = 0; index<hobbiesElementList.size();index++){
            if(hobbyValues.contains(hobbiesElementList.get(index).getText())){
                hobbiesElementList.get(index).click();
            }
        }

        WebElement fileUpload = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/DEMOQA.png";
        File file = new File(uploadValue);
        fileUpload.sendKeys(file.getAbsolutePath());

        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String addressValue = "Asta e adresaaaaaa";
        currentAddressElement.sendKeys(addressValue);

        WebElement stateElement = driver.findElement(By.id("state"));
        executor.executeScript("arguments[0].click();",stateElement);
        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("city"));
        executor.executeScript("arguments[0].click();",cityElement);
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Noida";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click()",submitElement);

        //wait explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(), "Student Name","Student Name text is not displayed correct in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstNameElement.getText()), "First Name value is not displayed correct in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastNameElement.getText()), "Last Name value is not displayed correct in the table");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email","Student Email text is not displayed correct in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), "gigel.banel@email.com","Email value is not displayed correct in the table");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender","Gender text is not displayed correct in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue,"Gender value is not displayed correct in the table");

        Assert.assertEquals(tableDescriptionList.get(3).getText(), "Mobile","Mobile text is not displayed correct in the table");
        Assert.assertEquals(tableValueList.get(3).getText(), "2222222222","Mobile value is not displayed correct in the table");

        //tema de facut restul de assert-uri
        //transformare lista in string delimitat cu virgula si spatiu pt hobbies si subjects- de cautat pe net
        String allSubjects = String.join(", ",subjectValues);
        Assert.assertEquals(tableDescriptionList.get(5).getText(),"Subjects","Subjects text is not displayed correct in the table");
        Assert.assertEquals(tableValueList.get(5).getText(),allSubjects,"Subject values are not displayed correct in the table");

        String allHobbies = String.join(", ",hobbyValues);
        Assert.assertEquals(tableDescriptionList.get(6).getText(),"Hobbies","Hobbies text is not displayed correct in the table");
        Assert.assertEquals(tableValueList.get(6).getText(),allHobbies,"Hobby values are not displayed correct in the table");

        String fileName = uploadValue.substring(19);
        Assert.assertEquals(tableDescriptionList.get(7).getText(), "Picture", "Picture text is not displayed correct in the table");
        Assert.assertEquals(tableValueList.get(7).getText(), fileName, "Picture filename is not displayed correct in the table");

        Assert.assertEquals(tableDescriptionList.get(8).getText(), "Address", "Address text is not displayed correct in the table");
        Assert.assertEquals(tableValueList.get(8).getText(), addressValue, "Address value is not displayed correct in the table");

        Assert.assertEquals(tableDescriptionList.get(9).getText(), "State and City","State and City text is not displayed correct in the table");
        Assert.assertTrue(tableValueList.get(9).getText().contains(stateValue), "State value is not displayed correct in the table");
        Assert.assertTrue(tableValueList.get(9).getText().contains(cityValue), "City value is not displayed correct in the table");

        driver.quit();
    }
}
