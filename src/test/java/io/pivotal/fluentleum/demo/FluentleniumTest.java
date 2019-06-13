package io.pivotal.fluentleum.demo;

import io.pivotal.fluentleum.demo.Pages.DuckDuckGoPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Demoing Fluentlenium Testing")
class FluentleniumTest extends BaseChromeTest {

    @Page
    DuckDuckGoPage duckDuckGoPage;

    @Test
    @DisplayName("goes to duckduckgo directly")
    void visitDuckDuckGo() {
        goTo("https://www.duckduckgo.com");
        $("#search_form_input_homepage").click().fill().withText("fluentlenium");
        $("#search_button_homepage").submit();
        assertThat(window().title()).contains("fluentlenium");
    }

    @Test
    @DisplayName("goes to duckduckgo using page object")
    void visitDuckDuckGoUsingPageObject() {
        goTo(duckDuckGoPage);

        duckDuckGoPage
                .enterText("fluentleum")
                .submit()
                .assertResultUrlsContain("https://fluentlenium.com/");
    }
}
