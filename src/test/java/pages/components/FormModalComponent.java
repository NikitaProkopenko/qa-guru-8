package pages.components;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormModalComponent {

    private String MODAL_TITLE = "Thanks for submitting the form";

    public FormModalComponent checkModalTitle() {
        $(".modal-title").shouldHave(text(MODAL_TITLE));

        return this;
    }

    public FormModalComponent checkUserName(String userName) {
        $(".table-responsive").$(byText("Student Name"))
                .sibling(0)
                .shouldHave(matchText(userName));

        return this;
    }

    public FormModalComponent checkUserEmail(String userEmail) {
        $(".table-responsive").$(byText("Student Email"))
                .sibling(0)
                .shouldHave(matchText(userEmail));

        return this;
    }

    public FormModalComponent checkGender(String gender) {
        $(".table-responsive").$(byText("Gender"))
                .sibling(0)
                .shouldHave(matchText(gender));

        return this;
    }

    public FormModalComponent checkPhone(String phone) {
        $(".table-responsive").$(byText("Mobile"))
                .sibling(0)
                .shouldHave(matchText(phone));

        return this;
    }

    public FormModalComponent checkDateOfBirth(String dateOfBirth) {
        $(".table-responsive").$(byText("Date of Birth"))
                .sibling(0)
                .shouldHave(matchText(dateOfBirth));

        return this;
    }

    public FormModalComponent checkSubjects(String subject) {
        $(".table-responsive").$(byText("Subjects"))
                .sibling(0)
                .shouldHave(matchText(subject));

        return this;
    }

    public FormModalComponent checkHobbies(String hobby) {
        $(".table-responsive").$(byText("Hobbies"))
                .sibling(0)
                .shouldHave(matchText(hobby));

        return this;
    }

    public FormModalComponent checkPicture(String picture) {
        $(".table-responsive").$(byText("Picture"))
                .sibling(0)
                .shouldHave(matchText(picture));

        return this;
    }

    public FormModalComponent checkAddress(String address) {
        $(".table-responsive").$(byText("Address"))
                .sibling(0)
                .shouldHave(matchText(address));

        return this;
    }

    public FormModalComponent checkStateAndCity(String stateAndCity) {
        $(".table-responsive").$(byText("State and City"))
                .sibling(0)
                .shouldHave(matchText(stateAndCity));

        return this;
    }
}
