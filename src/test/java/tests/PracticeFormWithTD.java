package tests;

import org.junit.jupiter.api.*;
import pages.PractiveFormPageObject;
import utils.TestDataGeneration;

import static utils.TestDataGeneration.*;


public class PracticeFormWithTD extends TestBase {

    PractiveFormPageObject page = new PractiveFormPageObject();
    TestDataGeneration testData = new TestDataGeneration();

    String firstName,
            lastName,
            userEmail,
            userPhoneNumber,
            userGender,
            userSubject,
            city,
            state,
            userHobby,
            userAddress,
            fileName,
            birthDay,
            birthMonth,
            birthYear;


    @Test
    void verifyFullInformationTest() {
        firstName = testData.generateFirstName();
        lastName = testData.generateLastName();
        userEmail = testData.generateUserEmail();
        userPhoneNumber = testData.generateUserPhone();
        userSubject = testData.generateSubject();
        userGender = testData.generateGender();
        userHobby = testData.generateHobby();
        userAddress = testData.generateAddress();
        fileName = testData.generateFileSelection();
        birthYear = testData.generateYear();
        birthMonth = testData.generateMonth();
        birthDay = testData.generateDay(birthMonth);
        state = testData.generateState();
        city = testData.generateCity(state);
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
        firstName = testData.generateFirstName();
        lastName = testData.generateLastName();
        userPhoneNumber = testData.generateUserPhone();
        userGender = testData.generateGender();

        page.openPage()
                .assertPageTitle("Student Registration Form");


        //fill in registration form
        page.setFistName(firstName)
                .setLastName(lastName)
                .setUserNumber(userPhoneNumber)
                .setGender(userGender)
                .submitForm();


        //Do assertions
        page.assertTableTitle("Thanks for submitting the form")
                .assertTableRecord("Student Name", firstName + " " + lastName)
                .assertTableRecord("Gender", userGender)
                .assertTableRecord("Mobile", userPhoneNumber)
                .closeTable()
                .assertPageTitle("Student Registration Form");

    }

    @Test
    void verifyNegativeTest() {
        firstName = testData.generateFirstName();
        lastName = testData.generateLastName();
        userPhoneNumber = testData.generateUserPhone();

        page.openPage()
                .assertPageTitle("Student Registration Form");

        page.setFistName(firstName)
                .setLastName(lastName)
                .setUserNumber(userPhoneNumber)
                .submitForm()
                .assertPageTitle("Student Registration Form");


    }

}
