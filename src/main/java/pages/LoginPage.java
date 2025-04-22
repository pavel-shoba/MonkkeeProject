package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage extends BasePage {
    private static final SelenideElement LOGIN_HEADING = $("[class='login__heading']");
    private static final SelenideElement LOGIN_BUTTON = $x("//button[contains(text(), 'Login')]");
    private static final SelenideElement ERROR_USER_MESSAGE = $x("//*[@name='login']/ancestor::div[1]/div");
    private static final SelenideElement ERROR_PASSWORD_MESSAGE = $x("//*[@name='password']/ancestor::div[2]//div[2]");
    private static final SelenideElement LOGIN_FAILED_MESSAGE = $x("//*[contains(@class, 'alert')]");

    /**
     * Open login page.
     *
     * @param url
     * @return the login page
     */
    public LoginPage openLoginPage(String url) {
        open(url);
        return this;
    }

    /**
     * Check that login page is opened
     *
     *@return the login page
     */
    public LoginPage isOpened() {
        LOGIN_HEADING.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Fill creds for user
     *
     * @param login
     * @param password
     * @return the login page
     */
    public LoginPage fillLoginForm(String login, String password) {
        isOpened();
        new Input("login").write(login);
        new Input("password").write(password);
        new Button().click(LOGIN_BUTTON);
        return this;
    }

    /**
     * Initializate login process
     *
     * @param login
     * @param password
     * @return the Entry page
     */
    public EntryPage login(String login, String password) {
        fillLoginForm(login, password);
        return new EntryPage();
    }

    /**
     * Method to get error for user
     *
     * @return text
     */
    public String getErrorEmptyUser() {
        try {
            String text = ERROR_USER_MESSAGE.getText();
            log.info("Error message for empty user: {}", text);
            return text;
        } catch (NullPointerException e) {
            log.info("Error message text about empty user not found", e);
            return null;
        }
    }

    /**
     * Method to get error for password
     *
     * @return text
     */
    public String getErrorEmptyPassword() {
        try {
            String text = ERROR_PASSWORD_MESSAGE.getText();
            log.info("Error message for empty password: {}", text);
            return text;
        } catch (NullPointerException e) {
            log.info("Error message text about empty password not found", e);
            return null;
        }
    }

    /**
     * Method to get error for all login form
     *
     * @return text
     */
    public String getAlertLoginFailed() {
        try {
            String text = LOGIN_FAILED_MESSAGE.getText();
            log.info("Login failed alert text: {}", text);
            return text;
        } catch (NullPointerException e) {
            log.info("Login failed text not found", e);
            return null;
        }
    }

    /**
     * Method to check visibility of heading
     *
     * @return true/false
     */
    public Boolean loginHeadingIsVisible() {
        try {
            LOGIN_HEADING.shouldBe(Condition.visible);
            boolean visible = LOGIN_HEADING.isDisplayed();
            log.info("Login heading is visible: {}", visible);
            return visible;
        } catch (Exception e) {
            log.info("Login heading is not visible", e);
            return false;
        }
    }
}
