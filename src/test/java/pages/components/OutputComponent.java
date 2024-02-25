package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OutputComponent {

    private SelenideElement tableTitleElement = $("#example-modal-sizes-title-lg");
    private SelenideElement mainTitleElement = $(byText("Student Registration Form"));
    private SelenideElement tableElement = $(".table-responsive");
    public void assertTable(String key, String value) {
        tableElement.$(byText(key)).parent().shouldHave(text(value));
    }
}
