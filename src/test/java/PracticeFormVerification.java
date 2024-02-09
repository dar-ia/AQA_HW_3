import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import java.io.File;
public class PracticeFormVerification {

    @BeforeAll
    static void commonConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl="https://demoqa.com/automation-practice-form";
        Configuration.holdBrowserOpen=true;
        Configuration.browserSize = "1280×1024";
    }

    @BeforeEach
    void beforeEachConfig(){
        open(Configuration.baseUrl);
        executeJavaScript("$('footer').remove()");
    }


    @Test
    void submitPassedTest(){
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

        File file = new File("src/test/resources/new 16.txt");

        $(".form-control-file").uploadFile(file);
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").scrollTo().click(usingJavaScript());

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

        $("#closeLargeModal").click();

        $(byText("Student Registration Form")).exists();


    }


}
