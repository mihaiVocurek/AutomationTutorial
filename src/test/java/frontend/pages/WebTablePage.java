package frontend.pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']")
    private List<WebElement> tableList;
    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "firstName")
    private WebElement editFirstNameElement;
    @FindBy(id = "lastName")
    private WebElement editLastNameElement;
    @FindBy(id = "userEmail")
    private WebElement editEmailElement;
    @FindBy(id = "age")
    private WebElement editAgeElement;
    @FindBy(id = "salary")
    private WebElement editSalaryElement;
    @FindBy(id = "department")
    private WebElement editDepartmentElement;

    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;

    public void addNewEntry(int tableSize, String firstNameValue, String lastNameValue, String emailValue,
                            String ageValue, String salaryValue, String departmentValue){
        elementHelper.validateListSize(tableList, tableSize);
        LoggerUtility.infoLog("The user validates that the table has " + tableSize + " rows");

        clickAddButton();
        fillFirstName(firstNameValue);
        fillLastName(lastNameValue);
        fillEmail(emailValue);
        fillAge(ageValue);
        fillSalary(salaryValue);
        fillDepartment(departmentValue);
        clickSubmit();

        int expectedTableSize = tableSize + 1;
        elementHelper.validateListSize(tableList,expectedTableSize);
        LoggerUtility.infoLog("The user validates that the table has " + expectedTableSize + " rows");

        elementHelper.validateElementContainsText(tableList.get(tableSize),firstNameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + firstNameValue+ " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),lastNameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + lastNameValue+ " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),emailValue);
        LoggerUtility.infoLog("The user validates that the table contains " + emailValue+ " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),ageValue);
        LoggerUtility.infoLog("The user validates that the table contains " + ageValue+ " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        LoggerUtility.infoLog("The user validates that the table contains " + salaryValue+ " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),departmentValue);
        LoggerUtility.infoLog("The user validates that the table contains " + departmentValue+ " value");
    }

    public void editNewEntry(int tableSize, String editFirstNameValue, String editLastNameValue, String editEmailValue,
                            String editAgeValue, String editSalaryValue, String editDepartmentValue){

        clickEditButton();
        editFirstName(editFirstNameValue);
        editLastName(editLastNameValue);
        editEmail(editEmailValue);
        editAge(editAgeValue);
        editSalary(editSalaryValue);
        editDepartment(editDepartmentValue);
        clickSubmit();

        int expectedTableSize = tableSize + 1;
        elementHelper.validateListSize(tableList,expectedTableSize);
        LoggerUtility.infoLog("The user validates that the table has " + expectedTableSize + " rows");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editFirstNameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editFirstNameValue+ " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editLastNameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editLastNameValue+ " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editEmailValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editEmailValue+ " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editAgeValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editAgeValue+ " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editSalaryValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editSalaryValue+ " value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editDepartmentValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editDepartmentValue+ " value");

    }

    public void deleteNewEntry(int tableSize){
        clickDeleteButton();
        elementHelper.validateListSize(tableList, tableSize);
    }

    public void clickAddButton(){
        elementHelper.clickJSElement(addElement);
        LoggerUtility.infoLog("The user clicks on add button");
    }

    public void fillFirstName(String firstNameValue){
        elementHelper.fillElement(firstNameElement,firstNameValue);
        LoggerUtility.infoLog("The user fills First Name field with value: "+ firstNameValue);
    }

    public void fillLastName(String lastNameValue){
        elementHelper.fillElement(lastNameElement,lastNameValue);
        LoggerUtility.infoLog("The user fills Last Name field with value: "+ lastNameValue);

    }

    public void fillEmail(String emailValue){
        elementHelper.fillElement(emailElement,emailValue);
        LoggerUtility.infoLog("The user fills Email field with value: "+ emailValue);

    }

    public void fillAge(String ageValue){
        elementHelper.fillElement(ageElement,ageValue);
        LoggerUtility.infoLog("The user fills Age field with value: "+ ageValue);

    }

    public void fillSalary(String salaryValue){
        elementHelper.fillElement(salaryElement,salaryValue);
        LoggerUtility.infoLog("The user fills Salary field with value: "+ salaryValue);

    }

    public void fillDepartment(String departmentValue){
        elementHelper.fillElement(departmentElement,departmentValue);
        LoggerUtility.infoLog("The user fills Department field with value: "+ departmentValue);

    }

    public void clickSubmit(){
        elementHelper.clickJSElement(submitElement);
        LoggerUtility.infoLog("The user clicks on submit button");
    }

    public void clickEditButton(){
        elementHelper.clickJSElement(editElement);
        LoggerUtility.infoLog("The user clicks on edit button");
    }

    public void editFirstName(String firstNameValue){
        elementHelper.clearFillElement(editFirstNameElement,firstNameValue);
        LoggerUtility.infoLog("The user edits First Name field with value: "+ firstNameValue);
    }

    public void editLastName(String lastNameValue){
        elementHelper.clearFillElement(editLastNameElement,lastNameValue);
        LoggerUtility.infoLog("The user edits Last Name field with value: "+ lastNameValue);
    }

    public void editEmail(String emailValue){
        elementHelper.clearFillElement(editEmailElement,emailValue);
        LoggerUtility.infoLog("The user edits Email field with value: "+ emailValue);
    }

    public void editAge(String ageValue){
        elementHelper.clearFillElement(editAgeElement,ageValue);
        LoggerUtility.infoLog("The user edits Age field with value: "+ ageValue);
    }

    public void editSalary(String salaryValue){
        elementHelper.clearFillElement(editSalaryElement,salaryValue);
        LoggerUtility.infoLog("The user edits Salary field with value: "+ salaryValue);
    }

    public void editDepartment(String departmentValue){
        elementHelper.clearFillElement(editDepartmentElement,departmentValue);
        LoggerUtility.infoLog("The user fills Department field with value: "+ departmentValue);
    }

    public void clickDeleteButton(){
        elementHelper.clickJSElement(deleteElement);
        LoggerUtility.infoLog("The user clicks on delete button");
    }

}
