package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.EntryPage;
import pages.LoginPage;

@Log4j2
public class LoginSteps extends BaseSteps {
    LoginPage loginPage;
    EntryPage entryPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
        this.entryPage = new EntryPage();
    }

    @Step("Login with creds")
    public void login(String user, String password, String url) {
        loginPage
                .openLoginPage(url)
                .login(user, password)
                .isOpened();
    }

    @Step("Login with creds and logout")
    public void logout(String user, String password, String url) {
        loginPage
                .openLoginPage(url)
                .login(user, password)
                .isOpened();
        entryPage.logout();
    }

    @Step("Check if login heading is visible")
    public boolean isLoginHeadingVisible() {
        return loginPage.loginHeadingIsVisible();
    }

    @Step("Get login failed alert text")
    public String getLoginFailedAlertText() {
        return loginPage.getAlertLoginFailed();
    }

    @Step("Get error message for empty user field")
    public String getEmptyUserErrorMessage() {
        return loginPage.getErrorEmptyUser();
    }

    @Step("Get error message for empty password field")
    public String getEmptyPasswordErrorMessage() {
        return loginPage.getErrorEmptyPassword();
    }
}
