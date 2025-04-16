package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class EntirePage extends BasePage {

    private static final SelenideElement USER_MENU = $("[class='user-menu']");
    private static final SelenideElement LOGOUT_BUTTON = $x("//span[contains(text(), 'Logout')]");
    private static final SelenideElement CREATE_ENTRY_BUTTON = $("[id='create-entry']");
    private static final SelenideElement BACK_TO_OVERVIEW_BUTTON = $("[id='back-to-overview']");
    public static final ElementsCollection DESCRIPTION_OF_CREATED_ENTRY = $$("[class=' entries__body']");
    public static final SelenideElement SUBMIT_TAG_BUTTON = $("[id='assign-new-tag']");
    public static final SelenideElement TAG_OF_CREATED_ENTRY = $x("//*[@class='entries__tags']/span");
    public static final ElementsCollection CHECKBOX_CREATED_ENTITY = $$x("//*[@class='entries__checkbox-datetime-wrapper']/div[1]/input");
    public static final SelenideElement DELETE_BUTTON = $("[id='delete-entries']");
    public static final SelenideElement SEARCH_ENTRY = $x("//*[@title='Search']");


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

    public EntirePage createEntry(String description) {
        new Button().click(CREATE_ENTRY_BUTTON);
        wait.until(ExpectedConditions.visibilityOf(BACK_TO_OVERVIEW_BUTTON));
        new Input("editable").writeEntryFields(description);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        return this;
    }

    public EntirePage createEntryWithTag(String description, String tagName) {
        new Button().click(CREATE_ENTRY_BUTTON);
        wait.until(ExpectedConditions.visibilityOf(BACK_TO_OVERVIEW_BUTTON));
        new Input("editable").writeEntryFields(description);
        new Input("new-tag").writeEntryFields(tagName);
        new Button().click(SUBMIT_TAG_BUTTON);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        return this;
    }

    public String getEntryDescription() {
        return DESCRIPTION_OF_CREATED_ENTRY.get(0).getText();
    }

    public String getEntryTag() {
        return TAG_OF_CREATED_ENTRY.getText();
    }

    public EntirePage createAndEditEntry(String description, String newDescription) {
        new Button().click(CREATE_ENTRY_BUTTON);
        wait.until(ExpectedConditions.visibilityOf(BACK_TO_OVERVIEW_BUTTON));
        new Input("editable").writeEntryFields(description);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        new Button().clickFirstElement(DESCRIPTION_OF_CREATED_ENTRY);
        new Input("editable").writeEntryFields(newDescription);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        return this;
    }

    public EntirePage createAndDeleteEntry(String description) {
        new Button().click(CREATE_ENTRY_BUTTON);
        wait.until(ExpectedConditions.visibilityOf(BACK_TO_OVERVIEW_BUTTON));
        new Input("editable").writeEntryFields(description);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        new Button().clickFirstElement(CHECKBOX_CREATED_ENTITY);
        new Button().click(DELETE_BUTTON);
        confirm();
        return this;
    }

    public EntirePage createEntryAndSearch(String description) {
        new Button().click(CREATE_ENTRY_BUTTON);
        wait.until(ExpectedConditions.visibilityOf(BACK_TO_OVERVIEW_BUTTON));
        new Input("editable").writeEntryFields(description);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        new Input("appendedInputButton").writeEntryFields(description);
        new Button().click(SEARCH_ENTRY);
        return this;
    }
}
