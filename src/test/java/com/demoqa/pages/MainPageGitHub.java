package com.demoqa.pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPageGitHub {
        private final SelenideElement searchField = $(".header-search-input");

        @Step("Search Repository {repository}")
        public MainPageGitHub searchRepository(String repository) {
            searchField.setValue(repository).pressEnter();
            return this;
        }
    }


