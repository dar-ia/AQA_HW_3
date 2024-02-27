package tests;

import org.junit.jupiter.api.*;
import pages.PractiveFormPageObject;
import utils.TestDataGeneration.*;

import static utils.TestDataGeneration.*;


public class PracticeFormWithTD extends TestBase {

    PractiveFormPageObject page = new PractiveFormPageObject();

    String firstName, lastName, userEmail, userPhoneNumber, userGender, userSubject, userHobby, userAddress;


    @Test
    void verifyFullInformationTest() {
        firstName=generateFirstName();
        lastName=generateLastName();
        userEmail=generateUserEmail();
        userPhoneNumber=generateUserPhone();
        userSubject=generateSubject();
        userGender=generateGender();
        userHobby=generateHobby();
        userAddress=generateAddress();
        page.openPage();

        page.assertPageTitle("Student Registration Form");

        //fill in registration form
        page.setFistName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber("9876543210")
                .setGender(userGender)
                .setCalendar("14", "January", "1998")
                .setSubject(userSubject)
                .setSubject("Biology")
                .setHobby(userHobby)
                .setCurrentAddress(userAddress)
                .uploadFie("new 16.txt")
                .setStateAndCity("NCR", "Delhi")
                .submitForm();


        //Do assertions
        page.assertTableTitle("Thanks for submitting the form")
                .assertTableRecord("Student Name", firstName+" "+lastName)
                .assertTableRecord("Student Email", userEmail)
                .assertTableRecord("Gender", userGender)
                .assertTableRecord("Mobile", "9876543210")
                .assertTableRecord("Date of Birth", "14 January,1998")
                .assertTableRecord("Subjects", userSubject)
                .assertTableRecord("Subjects", "Biology")
                .assertTableRecord("Hobbies", userHobby)
                .assertTableRecord("Picture", "new 16.txt")
                .assertTableRecord("Address", userAddress)
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
