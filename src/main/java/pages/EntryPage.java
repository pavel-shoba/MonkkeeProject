package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class EntryPage extends BasePage {

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
    public static final String FOOTER_ELEMENTS = "//*[@class='footer__link']";

    /**
     * Check that EntryPage is open
     *
     * @return EntryPage
     */
    public EntryPage isOpened() {
        USER_MENU.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Method to logout from system
     */
    public void logout() {
        new Button().click(LOGOUT_BUTTON);
    }

    /**
     * Check that user menu is visible
     *
     * @return true/false
     */
    public Boolean userMenuIsVisible() {
        try {
            boolean visible = USER_MENU.isDisplayed();
            log.info("User menu is visible: {}", visible);
            return visible;
        } catch (NoSuchElementException | NullPointerException e) {
            log.info("User menu element is not found", e);
            return false;
        }
    }

    /**
     * Method to create new entry with description
     *
     * @param description
     * @return EntryPage
     */
    public EntryPage createEntry(String description) {
        new Button().click(CREATE_ENTRY_BUTTON);
        wait.until(ExpectedConditions.visibilityOf(BACK_TO_OVERVIEW_BUTTON));
        new Input("editable").writeEntryFields(description);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        return this;
    }

    /**
     * Method to create new entry with description and tag
     *
     * @param description
     * @param tagName
     * @return EntryPage
     */
    public EntryPage createEntryWithTag(String description, String tagName) {
        new Button().click(CREATE_ENTRY_BUTTON);
        wait.until(ExpectedConditions.visibilityOf(BACK_TO_OVERVIEW_BUTTON));
        new Input("editable").writeEntryFields(description);
        new Input("new-tag").writeEntryFields(tagName);
        new Button().click(SUBMIT_TAG_BUTTON);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        return this;
    }

    /**
     * Method to get description of entry
     */
    public String getEntryDescription() {
        try {
            String text = DESCRIPTION_OF_CREATED_ENTRY.get(0).getText();
            log.info("Entry description found: {}", text);
            return text;
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            log.error("Description of entry not found", e);
            return null;
        }
    }

    /**
     * Method to get tag of entry
     */
    public String getEntryTag() {
        try {
            String tag = TAG_OF_CREATED_ENTRY.getText();
            log.info("Entry tag found: {}", tag);
            return tag;
        } catch (NullPointerException e) {
            log.error("Entry tag not found", e);
            return null;
        }
    }

    /**
     * Method to create new entry and edit after that
     *
     * @param description
     * @param newDescription
     * @return EntryPage
     */
    public EntryPage createAndEditEntry(String description, String newDescription) {
        new Button().click(CREATE_ENTRY_BUTTON);
        wait.until(ExpectedConditions.visibilityOf(BACK_TO_OVERVIEW_BUTTON));
        new Input("editable").writeEntryFields(description);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        new Button().clickFirstElement(DESCRIPTION_OF_CREATED_ENTRY);
        new Input("editable").writeEntryFields(newDescription);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        return this;
    }

    /**
     * Method to create new entry and delete after that
     *
     * @param description
     * @return EntryPage
     */
    public EntryPage createAndDeleteEntry(String description) {
        new Button().click(CREATE_ENTRY_BUTTON);
        wait.until(ExpectedConditions.visibilityOf(BACK_TO_OVERVIEW_BUTTON));
        new Input("editable").writeEntryFields(description);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        new Button().clickFirstElement(CHECKBOX_CREATED_ENTITY);
        new Button().click(DELETE_BUTTON);
        confirm();
        return this;
    }

    /**
     * Method to create new entry and search this one
     *
     * @param description
     * @return EntryPage
     */
    public EntryPage createEntryAndSearch(String description) {
        new Button().click(CREATE_ENTRY_BUTTON);
        wait.until(ExpectedConditions.visibilityOf(BACK_TO_OVERVIEW_BUTTON));
        new Input("editable").writeEntryFields(description);
        new Button().click(BACK_TO_OVERVIEW_BUTTON);
        new Input("appendedInputButton").writeEntryFields(description);
        new Button().click(SEARCH_ENTRY);
        return this;
    }

    /**
     * Method to get text for footer's elements
     */
    public List<String> getFooterTexts() {
        return $$x(FOOTER_ELEMENTS)
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }
}
