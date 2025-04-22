package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.EntryPage;
import pages.LoginPage;
import java.util.List;
import static pages.EntryPage.DESCRIPTION_OF_CREATED_ENTRY;

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

    @Step("Check if user menu is visible after login")
    public boolean isUserMenuVisible() {
        return entryPage.userMenuIsVisible();
    }

    @Step("Get description of created entry")
    public String getEntryDescription() {
        return entryPage.getEntryDescription();
    }

    @Step("Get tag name of created entry")
    public String getEntryTag() {
        return entryPage.getEntryTag();
    }

    @Step("Get list of footer texts")
    public List<String> getFooterTexts() {
        return entryPage.getFooterTexts();
    }

    @Step("Get the created entry that should be visible")
    public SelenideElement getVisibleCreatedEntry() {
        return DESCRIPTION_OF_CREATED_ENTRY.first().shouldBe(Condition.visible);
    }

    @Step("Check if the created entry is displayed")
    public boolean isCreatedEntryDisplayed() {
        return DESCRIPTION_OF_CREATED_ENTRY.first().isDisplayed();
    }
}
