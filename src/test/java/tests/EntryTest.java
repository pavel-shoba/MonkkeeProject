package tests;

import com.codeborne.selenide.Condition;
import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import static pages.EntryPage.DESCRIPTION_OF_CREATED_ENTRY;

public class EntryTest extends BaseTest {

    @Test(description = "QA-7 Create entry with some description")
    public void createEntryTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entrySteps.createEntryWithDescription(ENTRY_DESCRIPTION);
        softly.assertThat(DESCRIPTION_OF_CREATED_ENTRY.first().shouldBe(Condition.visible).exists());
        softly.assertThat(entrySteps.getEntryDescription()).isEqualTo(ENTRY_DESCRIPTION);
        softly.assertAll();
    }

    @Test(description = "QA-8 Create entry with description and tag" )
    public void createEntryWithTagTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entrySteps.createEntryWithDescriptionAndTag(ENTRY_DESCRIPTION, TAG);
        softly.assertThat(DESCRIPTION_OF_CREATED_ENTRY.first().shouldBe(Condition.visible).exists());
        softly.assertThat(entrySteps.getEntryTag()).isEqualTo(TAG);
        softly.assertAll();
    }

    @Test(description = "QA-9 Create entry and edit it" )
    public void createEntryAndEditTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entrySteps.createEntryAndEdit(ENTRY_DESCRIPTION, NEW_DESCRIPTION);
        Assert.assertEquals(entrySteps.getEntryDescription(), NEW_DESCRIPTION);
    }

    @Test(description = "QA-10 Create entry and delete" )
    public void createEntryAndDeleteTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entrySteps.createAndDeleteEntry(ENTRY_DESCRIPTION);
        Assert.assertFalse(DESCRIPTION_OF_CREATED_ENTRY.first().isDisplayed());
    }

    @Test(description = "QA-11 Create entry and search" )
    public void createEntryAndSearchTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entrySteps.createAndSearchEntry(ENTRY_DESCRIPTION);
        Assert.assertTrue(DESCRIPTION_OF_CREATED_ENTRY.first().shouldBe(Condition.visible).exists());
    }

    @Test(description = "QA-15 Check elements of footer")
    public void checkElementsOfFooterTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        softly.assertThat(entrySteps.getFooterTexts().get(0)).isEqualTo("Homepage");
        softly.assertThat(entrySteps.getFooterTexts().get(1)).isEqualTo("FAQ / Support");
        softly.assertThat(entrySteps.getFooterTexts().get(2)).isEqualTo("Buy license");
        softly.assertThat(entrySteps.getFooterTexts().get(3)).isEqualTo("Blog");
        softly.assertThat(entrySteps.getFooterTexts().get(4)).isEqualTo("Terms of use");
        softly.assertThat(entrySteps.getFooterTexts().get(5)).isEqualTo("Privacy policy");
        softly.assertThat(entrySteps.getFooterTexts().get(6)).isEqualTo("Legal notice");
        softly.assertAll();
    }
}
