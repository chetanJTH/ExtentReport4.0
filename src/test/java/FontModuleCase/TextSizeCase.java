package FontModuleCase;

import FontModule.TextSize;
import io.appium.java_client.android.AndroidDriver;

public class TextSizeCase {
    public TextSizeCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void TextSizeTestCase() {


        TextSize size = new TextSize(driver);

        try {
            size.TextSizeTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
