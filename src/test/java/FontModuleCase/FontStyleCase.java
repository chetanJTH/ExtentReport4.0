package FontModuleCase;

import FontModule.FontStyle;
import io.appium.java_client.android.AndroidDriver;

public class FontStyleCase {

    public FontStyleCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FontStyleTestCase() {


        FontStyle f = new FontStyle(driver);

        try {
            f.FontStyleTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

