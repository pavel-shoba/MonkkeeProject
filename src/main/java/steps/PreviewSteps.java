package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.PreviewPage;

@Log4j2
public class PreviewSteps extends BaseSteps {

    PreviewPage previewPage;

    public PreviewSteps() {
        this.previewPage = new PreviewPage();
    }

    @Step("Open preview page")
    public void openPreview(String url) {
        previewPage
                .openPreviewPage(url)
                .isOpened();
    }
}
