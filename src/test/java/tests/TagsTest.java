package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TagsTest extends BaseTest {

    @Test(description = "QA-13 Change name of created tag")
    public void changeTagNameTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entrySteps.createEntryWithDescriptionAndTag(ENTRY_DESCRIPTION, TAG);
        tagsSteps.changeTagName(NEW_TAG);
        Assert.assertEquals(tagsPage.getNewTagName(), NEW_TAG);
    }

    @Test(description = "QA-14 Deleting of created tag")
    public void deleteTagTest() {
        loginSteps.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
        entrySteps.createEntryWithDescriptionAndTag(ENTRY_DESCRIPTION, TAG);
        tagsSteps.deleteTag();
        Assert.assertFalse(tagsPage.tagIsNotVisible(), "Tag is still visible");
    }
}
