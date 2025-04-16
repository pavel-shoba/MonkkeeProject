package steps;

import io.qameta.allure.Step;
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

    @Step("Create entry with description")
    public void createEntryWithDescription(String description) {
        entirePage.createEntry(description);
    }

    @Step("Create entry with description and tag")
    public void createEntryWithDescriptionAndTag(String description, String tagName) {
        entirePage.createEntryWithTag(description, tagName);
    }

    @Step("Create entry and edit")
    public void createEntryAndEdit(String description, String newDescription) {
        entirePage.createAndEditEntry(description, newDescription);
    }

    @Step("Create entry and delete")
    public void createAndDeleteEntry(String description) {
        entirePage.createAndDeleteEntry(description);
    }

    @Step("Create entry and search")
    public void createAndSearchEntry(String description) {
        entirePage.createEntryAndSearch(description);
    }
}
