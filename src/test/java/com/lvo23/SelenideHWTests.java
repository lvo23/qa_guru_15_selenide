package com.lvo23;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

/**
 * @author Vlad Litvinov
 */
public class SelenideHWTests {

    @Test
    @DisplayName("Проверяем, что страница с инфой для предприятий открылась")
    void checkEnterpriseSolutionPageIsOpened() {

        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $("h1").shouldHave(text("Build like the best"));
    }

    @Test
    @DisplayName("Проверка d&d с помощью метода selenide.dragAndDropTo()")
    void dragAndDropTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    @DisplayName("Проверка d&d с помощью метода selenium.actions() – не работает")
    void dragAndDropTestUsingSelenideActions() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-a"))
                .release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

}
