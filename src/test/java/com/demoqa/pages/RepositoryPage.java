package com.demoqa.pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RepositoryPage {

    private final SelenideElement issuesTab = $("#issues-tab");

    @Step("Select tab Issue")
    public RepositoryPage selectIssuesTab() {
        issuesTab.click();
        return this;
    }

    @Step("Check Issue Number")
    public RepositoryPage checkIssueName(String numberIssue, String nameIssue) {
        $(String.format("#issue_%s_link", numberIssue)).shouldHave(text(nameIssue));
        return this;
    }
}

