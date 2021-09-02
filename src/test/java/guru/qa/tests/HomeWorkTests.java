package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void submitFormTest(){
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userNumber = "8900111111";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("label[for=gender-radio-1]").click();
        $("#userNumber").setValue(userNumber);

        $("#submit").scrollTo().click();

        $("table tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text(firstName + " " + lastName));
        $("table tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("table tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text(userNumber));
    }


}
