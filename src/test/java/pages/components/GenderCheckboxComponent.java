package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GenderCheckboxComponent {
    public void chooseGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }
}
