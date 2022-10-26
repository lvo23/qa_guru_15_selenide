package com.lvo23;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


}
