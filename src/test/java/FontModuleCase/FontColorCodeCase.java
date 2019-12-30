package FontModuleCase;

import FontModule.FontColor;
import FontModule.FontColorCode;
import io.appium.java_client.android.AndroidDriver;

public class FontColorCodeCase {

    public FontColorCodeCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FontColorCodeTestCase() {


        FontColorCode c = new FontColorCode(driver);

        try {
            c.FontColorCodeTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
