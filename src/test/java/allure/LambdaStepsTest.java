package allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE_TITLE = "69 nice";

    @Test
    public void checkIssueName() {
        step("Открываем GitHub", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").submit();
        });
        step("Открываем репозиторий " + REPOSITORY, () -> {
            $(By.linkText("eroshenkoam/allure-example")).click();
        });
        step("Открываем вкладку Issues ", () -> {
            $("#issues-tab").click();
        });
        step("Проверем наличие issue c названием " + ISSUE_TITLE, () -> {
            $("#issue_74_link").shouldHave(Condition.exactText("69 nice"));
            $("#issue_74_link").shouldBe(Condition.visible);
        });
    }
}
