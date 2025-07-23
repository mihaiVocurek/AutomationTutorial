package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Arrays;
import java.util.List;

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
        elementHelper.fillElement(lastNameElement, lastNameValue);
        elementHelper.fillElement(emailElement, emailValue);
        elementHelper.fillElement(mobileElement, mobileValue);

        for (int index = 0; index < subjectValues.size(); index++) {
            elementHelper.fillPressElement(subjectsElement, subjectValues.get(index), Keys.ENTER);
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

        pageHelper.scrollPage(0, 400);

        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbyValues.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickJSElement(hobbiesElementList.get(index));
            }
        }

        File file = new File(uploadValue);
        elementHelper.fillElement(uploadElement, file.getAbsolutePath());
        elementHelper.fillElement(addressElement, addressValue);
        elementHelper.clickJSElement(stateElement);
        elementHelper.fillPressElement(stateInputElement, stateValue, Keys.ENTER);
        elementHelper.clickJSElement(cityElement);
        elementHelper.fillPressElement(cityInputElement, cityValue, Keys.ENTER);
        elementHelper.clickJSElement(submitElement);
    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String emailValue,
                                   String genderValue, String mobileValue, List<String> subjectValues,
                                   List<String> hobbyValues, String uploadValue, String addressValue,
                                   String stateValue, String cityValue){
        elementHelper.validateElementEqualsText(tableDescriptionList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameValue);
        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1), "Student Email");
        elementHelper.validateElementEqualsText(tableValueList.get(1), emailValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
        elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
        elementHelper.validateElementEqualsText(tableValueList.get(3), mobileValue);

        String allSubjects = String.join(", ",subjectValues);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(5),"Subjects");
        elementHelper.validateElementEqualsText(tableValueList.get(5),allSubjects);

        String allHobbies = String.join(", ",hobbyValues);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(6),"Hobbies");
        elementHelper.validateElementEqualsText(tableValueList.get(6),allHobbies);

        String fileName = uploadValue.substring(19);
        File file = new File(fileName);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(7), "Picture");
        elementHelper.validateElementEqualsText(tableValueList.get(7), file.getName());

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8), addressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9),stateValue);
        elementHelper.validateElementContainsText(tableValueList.get(9),cityValue);
    }



}
