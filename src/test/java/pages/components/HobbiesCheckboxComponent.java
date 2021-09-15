package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HobbiesCheckboxComponent {
    public void chooseHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
    }
}
