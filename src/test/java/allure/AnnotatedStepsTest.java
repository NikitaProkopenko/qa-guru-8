package allure;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE_TITLE = "69 nice";

    @Test
    public void checkIssueVisibility() {
        WebSteps webSteps = new WebSteps();

        webSteps.openGitHubMainPage();
        webSteps.searchRepository(REPOSITORY);
        webSteps.openRepository(REPOSITORY);
        webSteps.openIssuesTab();
        webSteps.checkIssueVisibility(ISSUE_TITLE);
    }
}
