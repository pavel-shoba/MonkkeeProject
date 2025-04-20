package tests;

import constants.IConstants;
import org.testng.annotations.Test;

public class PreviewTest extends BaseTest {

    @Test(description = "QA-1 Open and check preview page")
    public void openPreviewPageTest() {
        previewSteps.openPreview(IConstants.PREVIEW_PAGE_URL);
        softly.assertThat(previewSteps.getMenuButtonText("menu1")).isEqualTo("About");
        softly.assertThat(previewSteps.getMenuButtonText("menu2")).isEqualTo("Features");
        softly.assertThat(previewSteps.getMenuButtonText("menu3")).isEqualTo("Security");
        softly.assertThat(previewSteps.getMenuButtonText("menu4")).isEqualTo("Prices");
        softly.assertAll();
    }
}
