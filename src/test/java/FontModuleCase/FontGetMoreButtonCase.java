package FontModuleCase;

import FontModule.FontColor;
import FontModule.FontGetMoreButton;
import io.appium.java_client.android.AndroidDriver;

public class FontGetMoreButtonCase {

    public FontGetMoreButtonCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FontGetMoreButtonTestCase() {


        FontGetMoreButton c = new FontGetMoreButton(driver);

        try {
            c.FontGetMoreButtonTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

