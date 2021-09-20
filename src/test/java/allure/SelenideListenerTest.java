package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideListenerTest {
    @Test
    public void checkIssueName() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").as("Нажать на поисковую строку").click();
        $(".header-search-input").as("Ввести значение поиска")
                .sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").as("Отправить поисковый запрос").submit();
        $(By.linkText("eroshenkoam/allure-example")).as("Открыть ссылку на репозиторий").click();
        $("#issues-tab").as("Открыть вкладку Issues").click();
        $("#issue_74_link").as("Показано issue c названием '69 nice'")
                .shouldHave(Condition.exactText("69 nice")).shouldBe(Condition.visible);
    }

}
