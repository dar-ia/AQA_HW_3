package tests;

import org.junit.jupiter.api.*;
import pages.PractiveFormPageObject;
import utils.TestDataGeneration.*;

import static utils.TestDataGeneration.*;


public class PracticeFormWithTD extends TestBase {

    PractiveFormPageObject page = new PractiveFormPageObject();

    String firstName, lastName, userEmail, userPhoneNumber, userGender, userSubject, city, state, userHobby, userAddress, fileName, birthDay, birthMonth, birthYear;


    @Test
    void verifyFullInformationTest() {
        firstName = generateFirstName();
        lastName = generateLastName();
        userEmail = generateUserEmail();
        userPhoneNumber = generateUserPhone();
        userSubject = generateSubject();
        userGender = generateGender();
        userHobby = generateHobby();
        userAddress = generateAddress();
        fileName = generateFileSelection();
        birthYear = generateYear();
        birthMonth = generateMonth();
        birthDay = generateDay(birthMonth);
        state = generateState();
        city = generateCity(state);
        page.openPage();

        page.assertPageTitle("Student Registration Form");

        //fill in registration form
        page.setFistName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(userPhoneNumber)
                .setGender(userGender)
                .setCalendar(birthDay, birthMonth, birthYear)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .setCurrentAddress(userAddress)
                .uploadFie(fileName)
                .setStateAndCity(state, city)
                .submitForm();


        //Do assertions
        page.assertTableTitle("Thanks for submitting the form")
                .assertTableRecord("Student Name", firstName + " " + lastName)
                .assertTableRecord("Student Email", userEmail)
                .assertTableRecord("Gender", userGender)
                .assertTableRecord("Mobile", userPhoneNumber)
                .assertTableRecord("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .assertTableRecord("Subjects", userSubject)
                .assertTableRecord("Hobbies", userHobby)
                .assertTableRecord("Picture", fileName)
                .assertTableRecord("Address", userAddress)
                .assertTableRecord("State and City", state + " " + city)
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
