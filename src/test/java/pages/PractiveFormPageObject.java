package pages;

import pages.components.CalendarComponent;

import com.codeborne.selenide.SelenideElement;
import pages.components.OutputComponent;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PractiveFormPageObject {

    private SelenideElement firstNameElement = $("#firstName");
    private SelenideElement lastNameElement = $("#lastName");
    private SelenideElement userEmailElement = $("#userEmail");
    private SelenideElement userNumberElement = $("#userNumber");
    private SelenideElement currentAddressElement = $("#currentAddress");
    private SelenideElement subjectElement = $("#subjectsInput");
    private SelenideElement stateElement = $("#react-select-3-input");
    private SelenideElement genderButtonsElement = $("#genterWrapper");
    private SelenideElement hobbiesElement = $("#hobbiesWrapper");

    private SelenideElement uploadFileElement = $(".form-control-file");

    private SelenideElement cityElement = $("#react-select-4-input");

    private SelenideElement tableTitleElement = $("#example-modal-sizes-title-lg");

    private SelenideElement mainTitleElement = $(byText("Student Registration Form"));
    private SelenideElement  tableCloseElement =$("#closeLargeModal");
    private SelenideElement submitFormElement = $("#submit");

    CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public PractiveFormPageObject setFistName(String firstName) {
        firstNameElement.setValue(firstName);
        return this;
    }

    public PractiveFormPageObject setLastName(String lastName) {
        lastNameElement.setValue(lastName);
        return this;
    }

    public PractiveFormPageObject setUserEmail(String userEmail) {
        userEmailElement.setValue(userEmail);
        return this;
    }

    public PractiveFormPageObject setUserNumber(String userNumber) {
        userNumberElement.setValue(userNumber);
        return this;
    }

    public PractiveFormPageObject setCurrentAddress(String address) {
        currentAddressElement.setValue(address);
        return this;
    }

    public PractiveFormPageObject setSubject(String subject) {
        subjectElement.setValue(subject).pressEnter();
        return this;
    }

    public PractiveFormPageObject setStateAndCity(String state, String city) {
        stateElement.setValue(state).pressEnter();
        cityElement.setValue(city).pressEnter();
        return this;
    }

    public PractiveFormPageObject setGender(String gender) {
        genderButtonsElement.$(byText(gender)).click();
        return this;

    }

    public PractiveFormPageObject setHobby(String hobby) {
        hobbiesElement.$(byText(hobby)).click();
        return this;
    }

    public PractiveFormPageObject setCalendar(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        calendar.setCalendarComponent(day, month, year);
        return this;
    }

    public PractiveFormPageObject uploadFie(String filename) {
        uploadFileElement.uploadFromClasspath(filename);
        return this;
    }

    public PractiveFormPageObject assertTable(String key, String value) {
        OutputComponent result = new OutputComponent();
        result.assertTable(key,value);
        return this;
    }

    public PractiveFormPageObject assertTableTitle(String title) {
        tableTitleElement.shouldHave(text(title));
        return this;
    }

    public PractiveFormPageObject assertPageTitle(String title) {
        mainTitleElement.shouldHave(text(title));
        return this;
    }
    public PractiveFormPageObject closeTable(){
        tableCloseElement.click(usingJavaScript());
        return this;
    }

    public PractiveFormPageObject submitForm(){
        submitFormElement.click();
        return this;
    }


}
