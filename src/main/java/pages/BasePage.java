package pages;

import constants.IConstants;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage implements IConstants {

    WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(20));
}
