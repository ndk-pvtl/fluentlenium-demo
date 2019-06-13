package io.pivotal.fluentleum.demo.Pages;


import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@PageUrl("https://duckduckgo.com")
public class DuckDuckGoPage extends FluentPage {

    @FindBy(id = "search_form_input_homepage")
    private FluentWebElement searchBox;

    @FindBy(id = "search_button_homepage")
    private FluentWebElement submitButton;

    @FindBy(className = "result__check")
    private List<FluentWebElement> resultUrls;

    public DuckDuckGoPage enterText(String text) {
        searchBox.click().fill().withText(text);
        return this;
    }

    public DuckDuckGoPage submit() {
        submitButton.click();
        return this;
    }

    public void assertResultUrlsContain(String url) {
        assertThat(resultUrls)
                .extracting((resultUrl) -> resultUrl.attribute("href"))
                .contains(url);
    }
}
