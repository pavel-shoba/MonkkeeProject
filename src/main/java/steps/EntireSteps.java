package steps;

import lombok.extern.log4j.Log4j2;
import pages.EntirePage;
import pages.LoginPage;

@Log4j2
public class EntireSteps extends BaseSteps {
    EntirePage entirePage;
    LoginPage loginPage;

    public EntireSteps() {
        this.entirePage = new EntirePage();
        this.loginPage = new LoginPage();
    }
}
