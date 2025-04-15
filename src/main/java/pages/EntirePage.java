package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class EntirePage {

    private static final SelenideElement USER_MENU = $("[class='user-menu']");
    private static final SelenideElement LOGOUT_BUTTON = $x("//span[contains(text(), 'Logout')]");
    private static final SelenideElement CREATE_ENTRY_BUTTON = $("[id='create-entry']");


    public EntirePage isOpened() {
        USER_MENU.shouldBe(Condition.visible);
        return this;
    }

    public void logout() {
        new Button().click(LOGOUT_BUTTON);
    }

    public Boolean userMenuIsVisible() {
        return USER_MENU.isDisplayed();
    }
}
