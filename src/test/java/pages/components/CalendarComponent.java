package pages.components;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import pages.PractiveFormPageObject;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    private SelenideElement setMounthDropdown = $(".react-datepicker__month-select");
    private SelenideElement setYearDropdown = $(".react-datepicker__year-select");

    private SelenideElement calendarDay(String day){
        String locator = ".react-datepicker__day.react-datepicker__day--0"+day;
        return $(locator);
    }

    public void setCalendarComponent(String day, String month, String year){
        setMounthDropdown.click();$(byText(month));

        setYearDropdown.click();
        $(byText(year)).click();

        SelenideElement setDay = calendarDay(day);
        setDay.click();
    }

}
