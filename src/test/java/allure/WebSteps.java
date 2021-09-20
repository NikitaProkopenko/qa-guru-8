package allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу GitHub")
    public void openGitHubMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий  {repo}")
    public void searchRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Открываем репозиторий  {repo}")
    public void openRepository(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Открываем вкладку Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверем наличие issues с название {issueTitle}")
    public void checkIssueVisibility(String issueTitle) {
        $("#issue_74_link").shouldHave(Condition.exactText(issueTitle));
        $("#issue_74_link").shouldBe(Condition.visible);
    }
}
