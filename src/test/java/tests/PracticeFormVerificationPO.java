package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import pages.PractiveFormPageObject;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormVerificationPO {

    PractiveFormPageObject page = new PractiveFormPageObject();

    @BeforeAll
    static void commonConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen=true;
        Configuration.browserSize = "1280×1024";
    }

    @BeforeEach
    void beforeEachConfig() {
        page.openPage();
    }

//    @AfterEach
//    void afterEachConfig() {
//        closeWebDriver();
//    }


    @Test
    void submitPassedTest() {

        //fill in registration form

        page.setFistName("First");
        page.setLastName("Last");
        page.setUserEmail("user@email.po");
        page.setUserNumber("9876543210");

        page.setGender("Female");
        page.setCalendar("14","January","1998");


        page.setSubject("English");
        page.setSubject("Biology");

        page.setHobby("Reading");
        page.setHobby("Sports");


        page.setCurrentAddress("street, 123house");

        //$(".form-control-file").uploadFromClasspath("new 16.txt");

        page.uploadFie("new 16.txt");
        page.setStateAndCity("NCR", "Delhi");

    }
}
