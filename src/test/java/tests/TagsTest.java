package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import static constants.IConstants.ENTRIES_PAGE_URL;

public class TagsTest extends BaseTest {

    @Test(description = "QA-13 Change name of created tag")
    public void changeTagNameTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entrySteps.createEntryWithDescriptionAndTag(ENTRY_DESCRIPTION, TAG);
        tagsSteps.changeTagName(NEW_TAG);
        Assert.assertEquals(tagsSteps.getUpdatedTagName(), NEW_TAG);
    }

    @Test(description = "QA-14 Deleting of created tag")
    public void deleteTagTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        tagsSteps.deleteAllPreviousTags(ENTRIES_PAGE_URL);
        entrySteps.createEntryWithDescriptionAndTag(ENTRY_DESCRIPTION, TAG);
        tagsSteps.deleteTag();
        Assert.assertTrue(tagsSteps.isTagNotVisible(), "Tag is still visible");
    }
}
