package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "QA-2 Login with valid data")
    public void successLoginTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        Assert.assertTrue(entrySteps.isUserMenuVisible(), "User menu is not visible");
    }

    @Test(description = "QA-3 Login with empty fields")
    public void loginWithEmptyFieldsTest() {
        loginSteps.login("", "", IConstants.LOGIN_PAGE_URL);
        softly.assertThat(loginSteps.getEmptyUserErrorMessage()).isEqualTo(ERROR_EMPTY_FIELDS);
        softly.assertThat(loginSteps.getEmptyPasswordErrorMessage()).isEqualTo(ERROR_EMPTY_FIELDS);
        softly.assertAll();
    }

    @Test(description = "QA-4 Login with incorrect user")
    public void loginWithIncorrectUserTest() {
        loginSteps.login("test@gmail.com", PASSWORD, IConstants.LOGIN_PAGE_URL);
        Assert.assertEquals(loginSteps.getLoginFailedAlertText(), ERROR_LOGIN_FAILED);
    }

    @Test(description = "QA-5 Login with incorrect password")
    public void loginWithIncorrectPasswordTest() {
        loginSteps.login(USER, "87654321", IConstants.LOGIN_PAGE_URL);
        Assert.assertEquals(loginSteps.getLoginFailedAlertText(), ERROR_LOGIN_FAILED);
    }

    @Test(description = "QA-6 Login and logout from authorized zone")
    public void logoutTest() {
        loginSteps.logout(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        Assert.assertTrue(loginSteps.isLoginHeadingVisible(), "Login heading is not visible");
    }
}
