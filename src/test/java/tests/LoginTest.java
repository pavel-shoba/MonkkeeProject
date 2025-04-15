package tests;

import constants.IConstants;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(description = "QA-2 Login with valid data")
    public void successLoginTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        Assert.assertTrue(entirePage.userMenuIsVisible(), "User menu is not visible");
    }

    @Test(description = "QA-3 Login with empty fields")
    public void loginWithEmptyFieldsTest() {
        SoftAssertions softly = new SoftAssertions();
        loginSteps.login("", "", IConstants.LOGIN_PAGE_URL);
        softly.assertThat(loginPage.getErrorEmptyUser()).isEqualTo(ERROR_EMPTY_FIELDS);
        softly.assertThat(loginPage.getErrorEmptyPassword()).isEqualTo(ERROR_EMPTY_FIELDS);
        softly.assertAll();
    }

    @Test(description = "QA-4 Login with incorrect user")
    public void loginWithIncorrectUserTest() {
        loginSteps.login("test@gmail.com", PASSWORD, IConstants.LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getAlertLoginFailed(), ERROR_LOGIN_FAILED);
    }

    @Test(description = "QA-5 Login with incorrect password")
    public void loginWithIncorrectPasswordTest() {
        loginSteps.login(USER, "87654321", IConstants.LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getAlertLoginFailed(), ERROR_LOGIN_FAILED);
    }

    @Test(description = "QA-6 Login and logout from authorized zone")
    public void logoutTest() {
        loginSteps.logout(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        Assert.assertTrue(loginPage.loginHeadingIsVisible(), "Login heading is not visible");
    }
}
