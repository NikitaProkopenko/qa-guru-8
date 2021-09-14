package guru.qa.tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;
import pages.components.GenderCheckboxComponent;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationForm extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    GenderCheckboxComponent genderCheckboxComponent = new GenderCheckboxComponent();
    CalendarComponent calendarComponent = new CalendarComponent();

    @Test
    void submitFormTest() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userNumber = "8900111111";
        String userEmail = "ivan@test.com";

        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail);
        genderCheckboxComponent.chooseGender("Male");
        registrationPage.typeUserNumber(userNumber);
        calendarComponent.setDate("March", "1992", "01");

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/image.png");
        $("#currentAddress").setValue("Test address");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").scrollTo().click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(matchText(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(matchText(userEmail));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(matchText("Male"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(matchText(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(matchText("01 March,1992"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(matchText("Maths"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(matchText("Music"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(matchText("image.png"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(matchText("Test address"));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(matchText("NCR Delhi"));
    }
}
