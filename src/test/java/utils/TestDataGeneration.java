package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataGeneration {
    private static Faker fakerTestData = new Faker(new Locale("en"));

    public static String generateFirstName() {
        return fakerTestData.name().firstName();
    }

    public static String generateLastName() {
        return fakerTestData.name().lastName();
    }

    public static String generateUserEmail() {
        return fakerTestData.internet().emailAddress();
    }

    public static String generateUserPhone() {
        return fakerTestData.phoneNumber().phoneNumber();
    }

    public static String generateGender() {
        return fakerTestData.options().option("Female", "Male");
    }

    public static String generateSubject() {
        return fakerTestData.options().option("Accounting", "Arts", "Biology", "Chemistry", "Computer Science", "Civics", "Commerce", "English", "Economics", "Hindi", "History", "Maths", "Physics", "Social Studies");
    }

    public static String generateHobby() {
        return fakerTestData.options().option("Sports", "Reading", "Music");
    }

    public static String generateFileSelection() {
        return fakerTestData.options().option("images.png", "notpng.jpeg", "ping.jpg");
    }

    public static String generateAddress(){
        return fakerTestData.address().fullAddress();
    }



//                .setCalendar("14", "January", "1998")

//                .setCurrentAddress("street, 123house")
//                .setStateAndCity("NCR", "Delhi")

}
