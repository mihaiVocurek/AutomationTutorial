package tests;

import pages.FormsPage;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;
import org.testng.annotations.Test;

import java.util.*;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithFormsMenu();

        FormsPage formsPage = new FormsPage(driver);
        formsPage.interactWithPracticeFormSubmenu();

        String firstNameValue = "Gigel";
        String lastNameValue = "Fanel";
        String emailValue = "Test@Test.com";
        String mobileValue = "0722222222";
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "Arts");
        String genderValue = "Male";
        List<String> hobbyValues = Arrays.asList("Reading", "Music");
        String uploadValue = "src/test/resources/DEMOQA.png";
        String addressValue = "Asta e adresaaaaaa";
        String stateValue = "NCR";
        String cityValue = "Noida";

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, emailValue, mobileValue,subjectValues,genderValue,
                                        hobbyValues,uploadValue,addressValue, stateValue, cityValue);

        practiceFormPage.validateFormValues(firstNameValue,lastNameValue,emailValue,genderValue,mobileValue,subjectValues,hobbyValues,
                uploadValue,addressValue,stateValue,cityValue);

    }
}
