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
        return ERROR_USER_MESSAGE.getText();
    }

    /**
     * Method to get error for password
     *
     * @return text
     */
    public String getErrorEmptyPassword() {
        return ERROR_PASSWORD_MESSAGE.getText();
    }

    /**
     * Method to get error for all login form
     *
     * @return text
     */
    public String getAlertLoginFailed() {
        return LOGIN_FAILED_MESSAGE.getText();
    }

    /**
     * Method to check visibility of heading
     *
     * @return true/false
     */
    public Boolean loginHeadingIsVisible() {
        LOGIN_HEADING.shouldBe(Condition.visible);
        return LOGIN_HEADING.isDisplayed();
    }
}
