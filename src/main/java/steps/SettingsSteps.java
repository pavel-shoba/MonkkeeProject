package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.EntryPage;
import pages.LoginPage;
import pages.SettingsPage;

@Log4j2
public class SettingsSteps extends BaseSteps {
    EntryPage entryPage;
    LoginPage loginPage;
    SettingsPage settingsPage;

    public SettingsSteps() {
        this.entryPage = new EntryPage();
        this.loginPage = new LoginPage();
        this.settingsPage = new SettingsPage();
    }

    @Step("Open settings page")
    public void openSettings() {
        settingsPage
                .openSettings()
                .isOpened();
    }

    @Step("Check if settings menu is displayed")
    public boolean isSettingsMenuDisplayed() {
        return settingsPage.settingsMenuIsDisplayed();
    }
}
