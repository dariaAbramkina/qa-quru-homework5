package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsPageTest {

    @BeforeEach
    public void setUp() {
        Configuration.baseUrl = "https://github.com/selenide/selenide";
    }

    @Test
    void SoftAssertionsPageIsExistOnWikiTab() {
        open("/wiki");
        $("[id=wiki-pages-filter]").sendKeys("SoftAssertions");
        $$("[data-filterable-for='wiki-pages-filter']")
                .filterBy(Condition.not(Condition.have(attribute("hidden"))))
                .first()
                .shouldHave(text("SoftAssertions"));
        $$("[data-filterable-for='wiki-pages-filter']")
                .filterBy(Condition.not(Condition.have(attribute("hidden"))))
                .first()
                .click();
        $("[class='markdown-body']").shouldHave(text("JUnit5"));
    }
}
