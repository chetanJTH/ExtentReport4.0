package FontModuleCase;

import FontModule.FontColor;
import io.appium.java_client.android.AndroidDriver;

public class FontColorCase {

    public FontColorCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FontColorTestCase() {


        FontColor c = new FontColor(driver);

        try {
            c.FontColorTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
