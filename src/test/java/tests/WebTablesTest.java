package tests;

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
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text() = 'Elements']"));
        executor.executeScript("arguments[0].click();", elementsMenu);

        WebElement webTableSubmenu = driver.findElement(By.xpath("//span[text() = 'Web Tables']"));
        executor.executeScript("arguments[0].click();", webTableSubmenu);

        int tableSize = 3;
        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize, "Default table size is different than 3");

        //Identificam un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Fanel";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Sandu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "fanel.sandu@email.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "22";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "5000";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "IT";
        departmentElement.sendKeys(departmentValue);

        WebElement addLine = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", addLine);

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
        executor.executeScript("arguments[0].click();", editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Mihai";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Kerucov";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "mihai.kerucov@email.com";
        editEmailElement.clear();
        editEmailElement.sendKeys(editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "55";
        editAgeElement.clear();
        editAgeElement.sendKeys(editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "11111";
        editSalaryElement.clear();
        editSalaryElement.sendKeys(editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "HR";
        editDepartmentElement.clear();
        editDepartmentElement.sendKeys(editDepartmentValue);

        WebElement editLine = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", editLine);

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
        executor.executeScript("arguments[0].click();", deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize, "Expected table size: " + tableSize + "is not correct");

        driver.quit();
    }
}