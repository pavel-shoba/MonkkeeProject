package tests;

import com.codeborne.selenide.Configuration;
import listener.TestListener;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.*;
import utils.PropertyReader;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    protected PreviewPage previewPage;
    protected LoginPage loginPage;
    protected PreviewSteps previewSteps;
    protected LoginSteps loginSteps;
    protected EntryPage entryPage;
    protected EntrySteps entrySteps;
    protected SettingsPage settingsPage;
    protected SettingsSteps settingsSteps;
    protected TagsPage tagsPage;
    protected TagsSteps tagsSteps;
    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String ERROR_EMPTY_FIELDS = "Mandatory field";
    public static String ERROR_LOGIN_FAILED = "Login failed";
    public static String ENTRY_DESCRIPTION = "My first entry";
    public static String NEW_DESCRIPTION = "My second entry";
    public static String TAG = "#daily";
    public static String NEW_TAG = "#summer";
    SoftAssertions softly = new SoftAssertions();

    public void initPages() {
        previewPage = new PreviewPage();
        previewSteps = new PreviewSteps();
        loginPage = new LoginPage();
        loginSteps = new LoginSteps();
        entryPage = new EntryPage();
        entrySteps = new EntrySteps();
        settingsPage = new SettingsPage();
        settingsSteps = new SettingsSteps();
        tagsPage = new TagsPage();
        tagsSteps = new TagsSteps();
    }

    @BeforeMethod
    public void initTest() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        if (Configuration.headless) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.browserSize = "1024x768";
        initPages();
    }

    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}
