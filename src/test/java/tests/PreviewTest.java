package tests;

import constants.IConstants;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class PreviewTest extends BaseTest {

    @Test(description = "QA-1 Open and check preview page")
    public void checkOpenningPreviewPageTest() {
        SoftAssertions softly = new SoftAssertions();
        previewSteps.openPreview(IConstants.PREVIEW_PAGE_URL);
        softly.assertThat(previewPage.getTextButtons("menu1")).isEqualTo("About");
        softly.assertThat(previewPage.getTextButtons("menu2")).isEqualTo("Features");
        softly.assertThat(previewPage.getTextButtons("menu3")).isEqualTo("Security");
        softly.assertThat(previewPage.getTextButtons("menu4")).isEqualTo("Prices");
        softly.assertAll();
    }
}
