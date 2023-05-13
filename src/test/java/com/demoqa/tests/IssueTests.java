package com.demoqa.tests;
import com.demoqa.pages.MainPageGitHub;
import com.demoqa.pages.RepositoryPage;
import com.demoqa.pages.SearchResult;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;


@Feature("Issue in repository")
@Story("Отображение Issue")
@Owner("OchkasovD")
@Severity(SeverityLevel.BLOCKER)
@Link(value = "Testing", url = "https://github.com")
@DisplayName("Check Issue Number on Issue Page")


public class IssueTests extends TestBase {

    MainPageGitHub mainPage= new MainPageGitHub();
    RepositoryPage repositoryPage = new RepositoryPage();

    SearchResult searchResult = new SearchResult();
    private static final String
            REPOSITORY = "OchkasovD/demoqa-tests-19",
            ISSUE_NUMBER = String.valueOf(1),
            ISSUE_NAME = "Test";


    @Test
    @DisplayName("Методом Selenide" )
    @Owner("OchkasovD")
    @Severity(SeverityLevel.BLOCKER)
    public void testIssueSearch() {
        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $("#issue_" + ISSUE_NUMBER + "_link").shouldHave(text(ISSUE_NAME));
    }

    @Test
    @DisplayName("Методом Лямбда шаги через step")
    public void testIssueLambdaStep(){

      step("Search Repository" + REPOSITORY, () -> {
          $(".header-search-input").setValue(REPOSITORY);
          $(".header-search-input").submit();
      });
      step("Click on repository link"+REPOSITORY,() -> {
          $(linkText(REPOSITORY)).click();
      });
        step("Open tab Issues", () -> {
            $("#issues-tab").click();
        });
        step("Check Issue Number" + ISSUE_NUMBER + "и именем " + ISSUE_NAME, () -> {
            $("#issue_" + ISSUE_NUMBER + "_link").shouldHave(text(ISSUE_NAME));
        });
    }

    @Test
    @DisplayName("Метод аннотацией step")
    public void testIssueStepAnnotated () {
        mainPage.searchRepository(REPOSITORY);
        searchResult.clickOnRepositoryLink(REPOSITORY);
        repositoryPage.selectIssuesTab();
        repositoryPage.checkIssueName(ISSUE_NUMBER, ISSUE_NAME);
    }
    }


