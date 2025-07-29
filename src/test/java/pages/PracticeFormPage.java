package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameElement;

    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameElement;

    @FindBy(css = "input[placeholder='name@example.com']")
    private WebElement emailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileElement;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsElement;

    @FindBy(css = "div[id = 'genterWrapper'] label[class='custom-control-label']")
    private List<WebElement> genderElementList;

    @FindBy(css = "div[id = 'hobbiesWrapper'] label[class='custom-control-label']")
    private List<WebElement> hobbiesElementList;

    @FindBy(id = "uploadPicture")
    private WebElement uploadElement;

    @FindBy(id = "currentAddress")
    private WebElement addressElement;

    @FindBy(id = "state")
    private WebElement stateElement;

    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;

    @FindBy(id = "city")
    private WebElement cityElement;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;

    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(xpath = "//table//td[1]")
    private List<WebElement> tableDescriptionList;

    @FindBy(xpath = "//table//td[2]")
    private List<WebElement> tableValueList;

    public void fillEntireForm(String firstNameValue, String lastNameValue, String emailValue,
                               String mobileValue, List<String> subjectValues, String genderValue,
                               List<String> hobbyValues, String uploadValue, String addressValue,
                               String stateValue, String cityValue) {

        elementHelper.fillElement(firstNameElement, firstNameValue);
        LoggerUtility.infoLog("The user fills First name field with value " + firstNameValue);
        elementHelper.fillElement(lastNameElement, lastNameValue);
        LoggerUtility.infoLog("The user fills Last name field with value " + lastNameValue);
        elementHelper.fillElement(emailElement, emailValue);
        LoggerUtility.infoLog("The user fills Email field with value " + emailValue);
        elementHelper.fillElement(mobileElement, mobileValue);
        LoggerUtility.infoLog("The user fills Mobile field with value " + mobileValue);

        for (int index = 0; index < subjectValues.size(); index++) {
            elementHelper.fillPressElement(subjectsElement, subjectValues.get(index), Keys.ENTER);
            LoggerUtility.infoLog("The user fills the subjects field with value: " + subjectValues.get(index));
        }

        switch (genderValue) {
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
        LoggerUtility.infoLog("The user checks from gender field the value: " + genderValue);

        pageHelper.scrollPage(0, 400);

        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbyValues.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickJSElement(hobbiesElementList.get(index));
                LoggerUtility.infoLog("The user fills the subjects field with value: " + hobbiesElementList.get(index).getText());
            }
        }

        File file = new File(uploadValue);
        elementHelper.fillElement(uploadElement, file.getAbsolutePath());
        LoggerUtility.infoLog("The user uploads the file " + file.getAbsolutePath());
        elementHelper.fillElement(addressElement, addressValue);
        LoggerUtility.infoLog("The user fills the address with value: " + addressValue);
        elementHelper.clickJSElement(stateElement);
        elementHelper.fillPressElement(stateInputElement, stateValue, Keys.ENTER);
        LoggerUtility.infoLog("The user fills the state with value: " + stateValue);
        elementHelper.clickJSElement(cityElement);
        elementHelper.fillPressElement(cityInputElement, cityValue, Keys.ENTER);
        LoggerUtility.infoLog("The user fills the city with value: " + cityValue);
        elementHelper.clickJSElement(submitElement);
        LoggerUtility.infoLog("The user clicks on submit button");
    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String emailValue,
                                   String genderValue, String mobileValue, List<String> subjectValues,
                                   List<String> hobbyValues, String uploadValue, String addressValue,
                                   String stateValue, String cityValue){
        elementHelper.validateElementEqualsText(tableDescriptionList.get(0),"Student Name");
        LoggerUtility.infoLog("The user validates the presence of value: Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameValue);
        LoggerUtility.infoLog("The user validates the presence of value: " + firstNameValue);
        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameValue);
        LoggerUtility.infoLog("The user validates the presence of value: " + lastNameValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1), "Student Email");
        LoggerUtility.infoLog("The user validates the presence of value: Student Email");
        elementHelper.validateElementEqualsText(tableValueList.get(1), emailValue);
        LoggerUtility.infoLog("The user validates the presence of value: " + emailValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
        LoggerUtility.infoLog("The user validates the presence of value: Gender");
        elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);
        LoggerUtility.infoLog("The user validates the presence of value: " + genderValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
        LoggerUtility.infoLog("The user validates the presence of value: Mobile");
        elementHelper.validateElementEqualsText(tableValueList.get(3), mobileValue);
        LoggerUtility.infoLog("The user validates the presence of value: " + mobileValue);

        String allSubjects = String.join(", ",subjectValues);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(5),"Subjects");
        LoggerUtility.infoLog("The user validates the presence of value: Subjects");
        elementHelper.validateElementEqualsText(tableValueList.get(5),allSubjects);
        LoggerUtility.infoLog("The user validates the presence of value: " + subjectValues);

        String allHobbies = String.join(", ",hobbyValues);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(6),"Hobbies");
        LoggerUtility.infoLog("The user validates the presence of value: Hobbies");
        elementHelper.validateElementEqualsText(tableValueList.get(6),allHobbies);
        LoggerUtility.infoLog("The user validates the presence of value: " + hobbyValues);

        String fileName = uploadValue.substring(19);
        File file = new File(fileName);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(7), "Picture");
        LoggerUtility.infoLog("The user validates the presence of value: Picture");
        elementHelper.validateElementEqualsText(tableValueList.get(7), file.getName());
        LoggerUtility.infoLog("The user validates the presence of value: " + file.getName());

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
        LoggerUtility.infoLog("The user validates the presence of value: Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8), addressValue);
        LoggerUtility.infoLog("The user validates the presence of value: " + addressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
        LoggerUtility.infoLog("The user validates the presence of value: State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9),stateValue);
        elementHelper.validateElementContainsText(tableValueList.get(9),cityValue);
        LoggerUtility.infoLog("The user validates the presence of value: " + stateValue + " " + cityValue);
    }



}
