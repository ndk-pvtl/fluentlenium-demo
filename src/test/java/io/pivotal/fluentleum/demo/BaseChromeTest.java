package io.pivotal.fluentleum.demo;

import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.fluentlenium.configuration.FluentConfiguration;

@FluentConfiguration(webDriver="chrome", capabilities = "{\"chromeOptions\": {\"args\": [\"headless\",\"disable-gpu\"]}}")
public class BaseChromeTest extends FluentTest {

}