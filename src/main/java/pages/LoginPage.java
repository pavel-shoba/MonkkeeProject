package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage extends BasePage {
    private static final SelenideElement LOGIN_HEADING = $("[class='login__heading']");
    private static final SelenideElement LOGIN_BUTTON = $x("//button[contains(text(), 'Login')]");
    private static final SelenideElement ERROR_USER_MESSAGE = $x("//*[@name='login']/ancestor::div[1]/div");
    private static final SelenideElement ERROR_PASSWORD_MESSAGE = $x("//*[@name='password']/ancestor::div[2]//div[2]");
    private static final SelenideElement LOGIN_FAILED_MESSAGE = $x("//*[contains(@class, 'alert')]");

    public LoginPage openLoginPage(String url) {
        open(url);
        return this;
    }

    public LoginPage isOpened() {
        LOGIN_HEADING.shouldBe(Condition.visible);
        return this;
    }

    public LoginPage fillLoginForm(String login, String password) {
        isOpened();
        new Input("login").write(login);
        new Input("password").write(password);
        new Button().click(LOGIN_BUTTON);
        return this;
    }

    public EntirePage login(String login, String password) {
        fillLoginForm(login, password);
        return new EntirePage();
    }

    public String getErrorEmptyUser() {
        return ERROR_USER_MESSAGE.getText();
    }

    public String getErrorEmptyPassword() {
        return ERROR_PASSWORD_MESSAGE.getText();
    }

    public String getAlertLoginFailed() {
        return LOGIN_FAILED_MESSAGE.getText();
    }

    public Boolean loginHeadingIsVisible() {
        LOGIN_HEADING.shouldBe(Condition.visible);
        return LOGIN_HEADING.isDisplayed();
    }
}
