package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCitySelectorComponent {
    SelenideElement stateInput = $("#state");
    SelenideElement stateSelector = $("#stateCity-wrapper");
    SelenideElement cityInput = $("#city");
    SelenideElement citySelector = $("#stateCity-wrapper");

    public StateAndCitySelectorComponent setState(String state) {
        stateInput.scrollTo().click();
        stateSelector.$(byText(state)).click();

        return this;
    }

    public StateAndCitySelectorComponent setCity(String city) {
        cityInput.click();
        citySelector.$(byText(city)).click();

        return this;
    }
}
