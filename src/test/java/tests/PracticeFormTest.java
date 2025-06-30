package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import sharedData.SharedData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.*;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text() = 'Forms']"));
        elementHelper.clickJSElement(formsMenu);

        WebElement practiceFormSubmenu = driver.findElement(By.xpath("//span[text() = 'Practice Form']"));
        elementHelper.clickJSElement(practiceFormSubmenu);

        //wait implicit
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identificam un element
        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        elementHelper.fillElement(firstNameElement,"Gigel");

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        elementHelper.fillElement(lastNameElement,"Banel");

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        elementHelper.fillElement(emailElement,"gigel.banel@email.com");

        WebElement mobileNoElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        elementHelper.fillElement(mobileNoElement,"22222222222");

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "Arts");
        for(int index = 0; index<subjectValues.size(); index++){
            elementHelper.fillElement(subjectsElement,subjectValues.get(index));
            elementHelper.pressElement(subjectsElement,Keys.ENTER);
        }

        String genderValue = "Male";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id = 'genterWrapper'] label[class='custom-control-label']"));
        switch (genderValue){
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
                break;
            default:
                System.out.println("Gender is not available");
        }

        //pt a da scroll in jos (daca valoare pozitiva , atunci face scroll la dr sau in jos)
        pageHelper.scrollPage(0,400);

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id = 'hobbiesWrapper'] label[class='custom-control-label']"));
        List<String> hobbyValues = Arrays.asList("Reading", "Music");
        for(int index = 0; index<hobbiesElementList.size();index++){
            if(hobbyValues.contains(hobbiesElementList.get(index).getText())){
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        WebElement fileUpload = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/DEMOQA.png";
        File file = new File(uploadValue);
        elementHelper.fillElement(fileUpload,file.getAbsolutePath());

        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String addressValue = "Asta e adresaaaaaa";
        elementHelper.fillElement(currentAddressElement,addressValue);

        WebElement stateElement = driver.findElement(By.id("state"));
        elementHelper.clickJSElement(stateElement);
        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        elementHelper.fillElement(stateInputElement,stateValue);
        elementHelper.pressElement(stateInputElement,Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("city"));
        elementHelper.clickJSElement(cityElement);
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Noida";
        elementHelper.fillElement(cityInputElement,cityValue);
        elementHelper.pressElement(cityInputElement,Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(submitElement);

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
    }
}
