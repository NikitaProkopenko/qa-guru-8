package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement userAddressInput = $("#currentAddress");
    private SelenideElement submitButton = $("#submit");

    public void openPage() {
        open("/automation-practice-form");
    }

    public void submitForm() {
        submitButton.scrollTo().click();
    }

    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage typeUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage typeUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    public RegistrationPage typeUserAddress(String userAddress) {
        userAddressInput.setValue(userAddress);

        return this;
    }
}
