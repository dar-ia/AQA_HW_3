package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormVerificationOriginal {



    @BeforeAll
    static void commonConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl="https://demoqa.com";
        //Configuration.holdBrowserOpen=true;
        Configuration.browserSize = "1280×1024";
    }

    @BeforeEach
    void beforeEachConfig(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    @AfterEach
    void afterEachConfig(){
        closeWebDriver();
    }


    @Test
    void submitPassedTest(){

        //fill in registration form


        $("#firstName").setValue("Name");
        $("#lastName").setValue("Surname");
        $("#userEmail").setValue("mail@example.com");

        $(byText("Female")).click();

        $("#userNumber").setValue("9876543210");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("January")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1998")).click();
        $(".react-datepicker__day.react-datepicker__day--014").click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Biology").pressEnter();

        $(byText("Reading")).click();
        $(byText("Sports")).click();

        $("#currentAddress").setValue("street, 123house");

        $(".form-control-file").uploadFromClasspath("new 16.txt");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").scrollTo().click(usingJavaScript());

        //verification that form was submitted successfully
        Assertions.assertEquals($("#example-modal-sizes-title-lg").getText(), "Thanks for submitting the form");

        Assertions.assertEquals($(".table.table-dark.table-striped.table-bordered.table-hover tr:nth-child(1) td:nth-child(2)").getText(), "Name Surname");
        Assertions.assertEquals($(".table.table-dark.table-striped.table-bordered.table-hover tr:nth-child(2) td:nth-child(2)").getText(), "mail@example.com");
        Assertions.assertEquals($(".table.table-dark.table-striped.table-bordered.table-hover tr:nth-child(3) td:nth-child(2)").getText(), "Female");
        Assertions.assertEquals($(".table.table-dark.table-striped.table-bordered.table-hover tr:nth-child(4) td:nth-child(2)").getText(), "9876543210");
        Assertions.assertEquals($(".table.table-dark.table-striped.table-bordered.table-hover tr:nth-child(5) td:nth-child(2)").getText(), "14 January,1998");
        Assertions.assertEquals($(".table.table-dark.table-striped.table-bordered.table-hover tr:nth-child(6) td:nth-child(2)").getText(), "English, Biology");
        Assertions.assertEquals($(".table.table-dark.table-striped.table-bordered.table-hover tr:nth-child(7) td:nth-child(2)").getText(), "Reading, Sports");
        Assertions.assertEquals($(".table.table-dark.table-striped.table-bordered.table-hover tr:nth-child(8) td:nth-child(2)").getText(), "new 16.txt");
        Assertions.assertEquals($(".table.table-dark.table-striped.table-bordered.table-hover tr:nth-child(9) td:nth-child(2)").getText(), "street, 123house");
        Assertions.assertEquals($(".table.table-dark.table-striped.table-bordered.table-hover tr:nth-child(10) td:nth-child(2)").getText(), "NCR Delhi");

        //verification that form was successfully closed
        $("#closeLargeModal").click(usingJavaScript());

        $(byText("Student Registration Form")).exists();


    }


}
