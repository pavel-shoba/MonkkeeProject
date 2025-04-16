package tests;

import com.codeborne.selenide.Condition;
import constants.IConstants;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static pages.EntirePage.DESCRIPTION_OF_CREATED_ENTRY;


public class EntireTest extends BaseTest {
    SoftAssertions softly = new SoftAssertions();

    @Test(description = "QA-7 Create entry with some description")
    public void createEntryTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entireSteps.createEntryWithDescription(ENTRY_DESCRIPTION);
        softly.assertThat(DESCRIPTION_OF_CREATED_ENTRY.first().shouldBe(Condition.visible).exists());
        softly.assertThat(entirePage.getEntryDescription()).isEqualTo(ENTRY_DESCRIPTION);
        softly.assertAll();
    }

    @Test(description = "QA-8 Create entry with description and tag" )
    public void createEntryWithTagTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entireSteps.createEntryWithDescriptionAndTag(ENTRY_DESCRIPTION, NEW_TAG);
        softly.assertThat(DESCRIPTION_OF_CREATED_ENTRY.first().shouldBe(Condition.visible).exists());
        softly.assertThat(entirePage.getEntryTag()).isEqualTo(NEW_TAG);
        softly.assertAll();
    }

    @Test(description = "QA-9 Create entry and edit it" )
    public void createEntryAndEditTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entireSteps.createEntryAndEdit(ENTRY_DESCRIPTION, NEW_DESCRIPTION);
        Assert.assertEquals(entirePage.getEntryDescription(), NEW_DESCRIPTION);
    }

    @Test(description = "QA-10 Create entry and delete" )
    public void createEntryAndDeleteTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entireSteps.createAndDeleteEntry(ENTRY_DESCRIPTION);
        Assert.assertFalse(DESCRIPTION_OF_CREATED_ENTRY.first().isDisplayed());
    }

    @Test(description = "QA-11 Create entry and search" )
    public void createEntryAndSearchTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entireSteps.createAndSearchEntry(ENTRY_DESCRIPTION);
        Assert.assertTrue(DESCRIPTION_OF_CREATED_ENTRY.first().shouldBe(Condition.visible).exists());
    }
}
