package pages;
import pages.components.CalendarComponent;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PractiveFormPageObject {

    private SelenideElement firstNameElement = $("#firstName");
    private SelenideElement lastNameElement = $("#lastName");
    private SelenideElement userEmailElement = $("#userEmail");
    private SelenideElement userNumberElement = $("#userNumber");
    private SelenideElement currentAddressElement = $("#currentAddress");
    private  SelenideElement subjectElement = $("#subjectsInput");
    private SelenideElement stateElement = $("#react-select-3-input");
    private SelenideElement genderButtonsElement = $("#genterWrapper");
    private SelenideElement hobbiesElement =  $("#hobbiesWrapper");

    private SelenideElement uploadFileElement = $(".form-control-file");

    private SelenideElement cityElement =$("#react-select-4-input");
    CalendarComponent calendar = new CalendarComponent();
    public void openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
    public void setFistName(String firstName){
        firstNameElement.setValue(firstName);
    }

    public void setLastName(String lastName){
        lastNameElement.setValue(lastName);
    }
    public void setUserEmail(String userEmail){
        userEmailElement.setValue(userEmail);
    }
    public void setUserNumber(String userNumber){
        userNumberElement.setValue(userNumber);
    }

    public void setCurrentAddress(String address){
        currentAddressElement.setValue(address);
    }
    public void setSubject(String subject){
        subjectElement.setValue(subject).pressEnter();
    }
    public void setStateAndCity(String state, String city){
        stateElement.setValue(state).pressEnter();
        stateElement.setValue(city).pressEnter();
    }
    public void setGender(String gender){
        genderButtonsElement.$(byText(gender)).click();
    }

    public void setHobby(String hobby){
        hobbiesElement.$(byText(hobby)).click();
    }

    public void setCalendar(String day, String month, String year){

        $("#dateOfBirthInput").click();
        calendar.setCalendarComponent(day,month,year);
    }

    public void uploadFie(String filename){
        uploadFileElement.uploadFromClasspath(filename);
    }


}
