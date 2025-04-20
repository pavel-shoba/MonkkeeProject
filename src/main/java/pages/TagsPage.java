package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.NoSuchElementException;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class TagsPage extends BasePage {
    private static final SelenideElement MANAGE_TAGS_BUTTON = $("[class='entries__manage-tags-link']");
    private static final SelenideElement MANAGE_TAGS_TITLE = $x("//*[contains(text(),'Manage Tags')]");
    private static final SelenideElement EDIT_TAG_BUTTON = $("[id='Icon_awesome-pen-nib']");
    private static final SelenideElement DELETE_TAG_BUTTON = $("[ng-click=\"deleteTag(tag)\"]");
    private static final SelenideElement SUBMIT_BUTTON = $x("//*[contains(@type, 'submit')]");
    private static final SelenideElement TAG_ON_PAGE = $x("//*[contains(@class, 'tags__table-cell')][1]");

    /**
     * Instantiates a new Tags page.
     */
    public TagsPage() {
    }

    /**
     * Method to check that Tags is opened
     *
     * @return Tags page
     */
    public TagsPage isOpened() {
        MANAGE_TAGS_TITLE.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Open Tags page
     *
     * @return Tags page
     */
    public TagsPage openTagsPage() {
        wait.until(ExpectedConditions.visibilityOf(MANAGE_TAGS_BUTTON));
        new Button().click(MANAGE_TAGS_BUTTON);
        isOpened();
        return this;
    }

    /**
     * Method to edit tag
     *
     * @param newTagName
     */
    public void editTag(String newTagName) {
        new Button().click(EDIT_TAG_BUTTON);
        new Input("tag").writeEntryFields(newTagName);
        new Button().click(SUBMIT_BUTTON);
    }

    /**
     * Method to get tag name
     *
     * @return text
     */
    public String getNewTagName() {
        try {
            String tagName = TAG_ON_PAGE.getText();
            log.info("New tag name found: {}", tagName);
            return tagName;
        } catch (NullPointerException e) {
            log.error("Text for tag not found on page", e);
            return null;
        }
    }

    /**
     * Method to delete tag
     */
    public void deleteTag() {
        new Button().click(DELETE_TAG_BUTTON);
        confirm();
    }

    /**
     * Method to check that tag is not displayed
     *
     * @return true/false
     */
    public Boolean tagIsNotVisible() {
        try {
            log.info("Tag on page is displayed: {}", TAG_ON_PAGE.isDisplayed());
            return !TAG_ON_PAGE.isDisplayed();
        } catch (NoSuchElementException | NullPointerException e) {
            log.info("Tag on page element is not found", e);
            return true;
        }
    }
}
