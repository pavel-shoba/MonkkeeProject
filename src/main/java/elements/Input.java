package elements;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$x;

public class Input {

    String label;
    public String inputLocator = "//*[@name='%s']";
    public String entryEntryLocator = "//*[@id='%s']";

    public Input(String label) {
        this.label = label;
    }

    public Input write(String text) {
        $x(String.format(inputLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeEntryFields(String text) {
        $x(String.format(entryEntryLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }
}
