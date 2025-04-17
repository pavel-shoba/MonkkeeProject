package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest {

    @Test(description = "QA-12 Open settings page and check visibility")
    public void openSettingsPageTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        settingsSteps.openSettings();
        Assert.assertTrue(settingsPage.settingsMenuIsDisplayed(), "Settings page is not displayed");
    }
}
