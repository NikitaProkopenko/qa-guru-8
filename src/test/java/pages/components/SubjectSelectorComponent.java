package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectSelectorComponent {
    public void chooseSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }
}
