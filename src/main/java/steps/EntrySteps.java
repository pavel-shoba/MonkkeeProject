package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.EntryPage;
import pages.LoginPage;

@Log4j2
public class EntrySteps extends BaseSteps {
    EntryPage entryPage;
    LoginPage loginPage;

    public EntrySteps() {
        this.entryPage = new EntryPage();
        this.loginPage = new LoginPage();
    }

    @Step("Create entry with description")
    public void createEntryWithDescription(String description) {
        entryPage.createEntry(description);
    }

    @Step("Create entry with description and tag")
    public void createEntryWithDescriptionAndTag(String description, String tagName) {
        entryPage.createEntryWithTag(description, tagName);
    }

    @Step("Create entry and edit")
    public void createEntryAndEdit(String description, String newDescription) {
        entryPage.createAndEditEntry(description, newDescription);
    }

    @Step("Create entry and delete")
    public void createAndDeleteEntry(String description) {
        entryPage.createAndDeleteEntry(description);
    }

    @Step("Create entry and search")
    public void createAndSearchEntry(String description) {
        entryPage.createEntryAndSearch(description);
    }
}
