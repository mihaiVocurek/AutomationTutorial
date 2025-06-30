package tests;

import helperMethods.ElementHelper;
import sharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends SharedData {


    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text() = 'Elements']"));
        elementHelper.clickJSElement(elementsMenu);

        WebElement webTableSubmenu = driver.findElement(By.xpath("//span[text() = 'Web Tables']"));
        elementHelper.clickJSElement(webTableSubmenu);

        int tableSize = 3;
        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize, "Default table size is different than 3");

        //Identificam un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementHelper.clickElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Fanel";
        elementHelper.fillElement(firstNameElement,firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Sandu";
        elementHelper.fillElement(lastNameElement,lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "fanel.sandu@email.com";
        elementHelper.fillElement(emailElement,emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "22";
        elementHelper.fillElement(ageElement,ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "5000";
        elementHelper.fillElement(salaryElement,salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "IT";
        elementHelper.fillElement(departmentElement,departmentValue);

        WebElement addLine = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(addLine);

        tableList = driver.findElements(By.xpath("//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize+1, "Expected table size: + tableSize + is not correct");
        Assert.assertTrue(tableList.get(tableSize).getText().contains(firstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(lastNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(departmentValue));

        //Edit functionality
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementHelper.clickJSElement(editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Mihai";
        elementHelper.clearElement(editFirstNameElement);
        elementHelper.fillElement(editFirstNameElement,editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Kerucov";
        elementHelper.clearElement(editLastNameElement);
        elementHelper.fillElement(editLastNameElement,editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "mihai.kerucov@email.com";
        elementHelper.clearElement(editEmailElement);
        elementHelper.fillElement(editEmailElement,editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "55";
        elementHelper.clearElement(editAgeElement);
        elementHelper.fillElement(editAgeElement,editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "11111";
        elementHelper.clearElement(editSalaryElement);
        elementHelper.fillElement(editSalaryElement,editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "HR";
        elementHelper.clearElement(editDepartmentElement);
        elementHelper.fillElement(editDepartmentElement,editDepartmentValue);

        WebElement editLine = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(editLine);

        tableList = driver.findElements(By.xpath("//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize+1, "Expected table size: " + tableSize + "is not correct");

        Assert.assertTrue(tableList.get(tableSize).getText().contains(editFirstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editLastNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editEmailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editAgeValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editSalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editDepartmentValue));

        //Delete functionality
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementHelper.clickJSElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize, "Expected table size: " + tableSize + "is not correct");

    }
}