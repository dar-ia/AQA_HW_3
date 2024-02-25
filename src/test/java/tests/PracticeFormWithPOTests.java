package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import pages.PractiveFormPageObject;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPOTests {

    PractiveFormPageObject page = new PractiveFormPageObject();

    @BeforeAll
    static void commonConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1280×1024";
    }

    @BeforeEach
    void beforeEachConfig() {
        page.openPage();
    }

    @AfterEach
    void afterEachConfig() {
        closeWebDriver();
    }


    @Test
    void verifyWithPageObjectTest() {

        page.assertPageTitle("Student Registration Form");

        //fill in registration form
        page.setFistName("First")
                .setLastName("Last")
                .setUserEmail("user@email.po")
                .setUserNumber("9876543210")
                .setGender("Female")
                .setCalendar("14", "January", "1998")
                .setSubject("English")
                .setSubject("Biology")
                .setHobby("Reading")
                .setHobby("Sports")
                .setCurrentAddress("street, 123house")
                .uploadFie("new 16.txt")
                .setStateAndCity("NCR", "Delhi");

        $("#submit").click();

        //Do assertions
        page.assertTableTitle("Thanks for submitting the form")
                .assertTable("Student Name", "First Last")
                .assertTable("Student Email", "user@email.po")
                .assertTable("Gender", "Female")
                .assertTable("Mobile", "9876543210")
                .assertTable("Date of Birth", "14 January,1998")
                .assertTable("Subjects", "English")
                .assertTable("Subjects", "Biology")
                .assertTable("Hobbies", "Reading")
                .assertTable("Hobbies", "Sports")
                .assertTable("Picture", "new 16.txt")
                .assertTable("Address", "street, 123house")
                .assertTable("State and City", "NCR Delhi");

        $("#closeLargeModal").click(usingJavaScript());
        page.assertPageTitle("Student Registration Form");


    }
}
