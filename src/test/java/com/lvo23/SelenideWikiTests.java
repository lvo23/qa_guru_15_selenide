package com.lvo23;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Vlad Litvinov
 */
public class SelenideWikiTests {

    @Test
    @DisplayName("Проверить, что на странице SoftAssertions в разделе Wiki есть пример для JUnit5")
    void JUnitExampleOnSoftAssertionsPageTest() {

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body h1").shouldHave(text("Welcome to the selenide wiki!"));
        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions")).$(linkText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }

}
