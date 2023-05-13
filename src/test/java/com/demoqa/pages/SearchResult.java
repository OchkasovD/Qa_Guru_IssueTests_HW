package com.demoqa.pages;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;
public class SearchResult {

    @Step("Click on repository link {repository}")
    public SearchResult clickOnRepositoryLink(String repository) {
        $(linkText(repository)).click();
        return this;
    }
}

