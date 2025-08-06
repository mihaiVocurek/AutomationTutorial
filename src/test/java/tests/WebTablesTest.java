package tests;

import pages.ElementsPage;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;
import org.testng.annotations.Test;
import suite.Suite;

public class WebTablesTest extends SharedData {


    @Test(groups = {Suite.REGRESSION_SUITE,Suite.ELEMENTS_SUITE})
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.interactWithWebTablesSubmenu();

        int tableSize = 3;
        String firstNameValue = "Fanel";
        String lastNameValue = "Sandu";
        String emailValue = "fanel.sandu@email.com";
        String ageValue = "22";
        String salaryValue = "5000";
        String departmentValue = "IT";

        String editFirstNameValue = "Mihai";
        String editLastNameValue = "Kerucov";
        String editEmailValue = "mihai.kerucov@email.com";
        String editAgeValue = "55";
        String editSalaryValue = "11111";
        String editDepartmentValue = "HR";

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addNewEntry(tableSize,firstNameValue,lastNameValue,emailValue,ageValue,salaryValue,departmentValue);

        webTablePage.editNewEntry(tableSize, editFirstNameValue, editLastNameValue, editEmailValue, editAgeValue,
                editSalaryValue, editDepartmentValue);

        webTablePage.deleteNewEntry(tableSize);

    }
}