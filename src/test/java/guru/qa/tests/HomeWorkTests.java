package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void submitFormTest() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userNumber = "8900111111";
        String userEmail = "ivan@test.com";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
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
