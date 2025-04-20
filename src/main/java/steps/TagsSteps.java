package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.TagsPage;

@Log4j2
public class TagsSteps extends BaseSteps {
    TagsPage tagsPage;

    public TagsSteps() {
        this.tagsPage = new TagsPage();
    }

    @Step("Change tag name")
    public void changeTagName(String newTagName) {
        tagsPage
                .openTagsPage()
                .editTag(newTagName);
    }

    @Step("Delete tag")
    public void deleteTag() {
        tagsPage
                .openTagsPage()
                .deleteTag();
    }

    @Step("Check that tag is not visible on the page")
    public boolean isTagNotVisible() {
        return tagsPage.tagIsNotVisible();
    }

    @Step("Get the updated tag name from the page")
    public String getUpdatedTagName() {
        return tagsPage.getNewTagName();
    }
}
