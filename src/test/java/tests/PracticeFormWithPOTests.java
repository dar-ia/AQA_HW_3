package tests;
import org.junit.jupiter.api.*;
import pages.PractiveFormPageObject;


public class PracticeFormWithPOTests extends TestBase {

    PractiveFormPageObject page = new PractiveFormPageObject();


    @Test
    void verifyFullInformationTest() {
        page.openPage();

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
                .setStateAndCity("NCR", "Delhi")
                .submitForm();


        //Do assertions
        page.assertTableTitle("Thanks for submitting the form")
                .assertTableRecord("Student Name", "First Last")
                .assertTableRecord("Student Email", "user@email.po")
                .assertTableRecord("Gender", "Female")
                .assertTableRecord("Mobile", "9876543210")
                .assertTableRecord("Date of Birth", "14 January,1998")
                .assertTableRecord("Subjects", "English")
                .assertTableRecord("Subjects", "Biology")
                .assertTableRecord("Hobbies", "Reading")
                .assertTableRecord("Hobbies", "Sports")
                .assertTableRecord("Picture", "new 16.txt")
                .assertTableRecord("Address", "street, 123house")
                .assertTableRecord("State and City", "NCR Delhi")
                .closeTable()
                .assertPageTitle("Student Registration Form");
    }

    @Test
    void verifyMinimalInformationTest() {
        page.openPage()
                .assertPageTitle("Student Registration Form");


        //fill in registration form
        page.setFistName("First")
                .setLastName("Last")
                .setUserNumber("9876543210")
                .setGender("Female")
                .submitForm();


        //Do assertions
        page.assertTableTitle("Thanks for submitting the form")
                .assertTableRecord("Student Name", "First Last")
                .assertTableRecord("Gender", "Female")
                .assertTableRecord("Mobile", "9876543210")
                .closeTable()
                .assertPageTitle("Student Registration Form");

    }

    @Test
    void verifyNegativeTest() {
        page.openPage()
                .assertPageTitle("Student Registration Form");
        page.setFistName("First")
                .setLastName("Last")
                .setUserNumber("9876543210")
                .submitForm()
                .assertPageTitle("Student Registration Form");


    }

}
