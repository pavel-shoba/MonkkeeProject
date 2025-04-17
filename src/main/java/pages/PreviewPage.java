package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import java.util.Map;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class PreviewPage extends BasePage {
    private static final SelenideElement HEADER_MENU = $("[class='header__menu-ul']");
    private static final SelenideElement ABOUT_BUTTON = $x("//*[@class='header__menu-ul']/li[1]/a");
    private static final SelenideElement FEATURES_BUTTON = $x("//*[@class='header__menu-ul']/li[2]/a");
    private static final SelenideElement SECURITY_BUTTON = $x("//*[@class='header__menu-ul']/li[3]/a");
    private static final SelenideElement PRICES_BUTTON = $x("//*[@class='header__menu-ul']/li[4]/a");
    private Map<String, SelenideElement> MENU_BUTTONS = Map.of(
            "menu1", ABOUT_BUTTON,
            "menu2", FEATURES_BUTTON,
            "menu3", SECURITY_BUTTON,
            "menu4", PRICES_BUTTON
    );

    /**
     * Method to open Preview page
     *
     * @param url
     * @return preview page
     */
    public PreviewPage openPreviewPage(String url) {
        open(url);
        return this;
    }

    /**
     * Method to check that Preview is opened
     *
     * @return preview page
     */
    public PreviewPage isOpened() {
        HEADER_MENU.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Method to get text of buttons
     *
     * @return text
     */
    public String getTextButtons(String name) {
        return MENU_BUTTONS.get(name.toLowerCase()).getText();
    }
}
