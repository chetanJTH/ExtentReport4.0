package FontModuleCase;

import FontModule.TextPositionButtons;
import io.appium.java_client.android.AndroidDriver;

public class TextPositionButtonsCase {
    public TextPositionButtonsCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void TextPositionButtonsTestCase() {


        TextPositionButtons T = new TextPositionButtons(driver);

        try {
            T.TextPositionButtonsTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}