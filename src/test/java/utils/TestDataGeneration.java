package utils;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;
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
        return fakerTestData.phoneNumber().subscriberNumber(10);
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

    public static String generateAddress() {
        return fakerTestData.address().fullAddress();
    }

    public static String generateYear() {
        return String.valueOf(fakerTestData.number().numberBetween(1920, 2024));
    }

    public static String generateMonth() {
        return fakerTestData.options().option("January", "February", "March", "April", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String generateDay(String month) {
        String dayOfMonth = "";
        if (month.equals("February")) {
            dayOfMonth = String.valueOf(fakerTestData.number().numberBetween(1, 28));
        } else if (List.of("January", "March", "May", "July", "August", "October", "December").contains(month)) {
            dayOfMonth = String.valueOf(fakerTestData.number().numberBetween(1, 31));
        } else if (List.of("April", "June", "September", "November").contains(month)) {
            dayOfMonth = String.valueOf(fakerTestData.number().numberBetween(1, 30));
        }
        return dayOfMonth;
    }

    public static String generateState() {
        return fakerTestData.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    }

    public static String generateCity(String state) {
        String city = "";
        if (state.equals("NCR")) {
            city = fakerTestData.options().option("Delhi", "Gurgaon", "Noida");
        } else if (state.equals("Uttar Pradesh")) {
            city = fakerTestData.options().option("Agra", "Lucknow", "Merrut");
        } else if (state.equals("Haryana")) {
            city = fakerTestData.options().option("Karnal", "Panipat");
        } else {
            city = fakerTestData.options().option("Jaipur", "Jaiselmer");
        }
        return city;
    }


    @Test
    public void phoneTest() {
        String year = generateYear();

        String month = generateMonth();
        System.out.println(month);
        String day = generateDay(month);
        System.out.println(day);
        System.out.println(day + " " + month + " " + year);

        System.out.println(day + " " + month + " " + year);

        System.out.println(day + " " + month + " " + year);
    }

}
