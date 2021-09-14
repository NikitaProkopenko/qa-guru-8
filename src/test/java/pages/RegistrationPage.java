package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    public void openPage() {
        open("/automation-practice-form");
    }

    public RegistrationPage typeFirstName(String firstName) {
        $("#firstName").setValue(firstName);

        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationPage typeUserEmail(String userEmail) {
        $("#userEmail").setValue(userEmail);

        return this;
    }

    public RegistrationPage typeUserNumber(String userNumber) {
        $("#userNumber").setValue(userNumber);

        return this;
    }
}
