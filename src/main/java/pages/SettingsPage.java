package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class SettingsPage extends BasePage {

    public static final SelenideElement SETTINGS_BUTTON = $x("//*[contains(text(),'Settings')]");
    private static final SelenideElement SETTINGS_MENU = $("[class='settings__menu']");

    /**
     * Instantiates a new Settings page.
     */
    public SettingsPage() {
    }

    /**
     * Method to check that Settings is opened
     *
     * @return Settings page
     */
    public SettingsPage isOpened() {
        SETTINGS_MENU.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Method to check that Settings menu is displayed
     *
     * @return true/false
     */
    public Boolean settingsMenuIsDisplayed() {
        return SETTINGS_MENU.isDisplayed();
    }

    /**
     * Open Settings page
     *
     * @return Settings page
     */
    public SettingsPage openSettings() {
        new Button().click(SETTINGS_BUTTON);
        return this;
    }
}
