package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.EntirePage;
import pages.LoginPage;
import pages.PreviewPage;
import steps.EntireSteps;
import steps.LoginSteps;
import steps.PreviewSteps;
import utils.PropertyReader;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    protected PreviewPage previewPage;
    protected LoginPage loginPage;
    protected PreviewSteps previewSteps;
    protected LoginSteps loginSteps;
    protected EntirePage entirePage;
    protected EntireSteps entireSteps;
    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String ERROR_EMPTY_FIELDS = "Mandatory field";
    public static String ERROR_LOGIN_FAILED = "Login failed";

    public void initPages() {
        previewPage = new PreviewPage();
        previewSteps = new PreviewSteps();
        loginPage = new LoginPage();
        loginSteps = new LoginSteps();
        entirePage = new EntirePage();
        entireSteps = new EntireSteps();
    }

    @BeforeMethod
    public void initTest() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless  = false;
        Configuration.browserSize = "1024x768";
        initPages();
    }

    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}
