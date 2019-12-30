package FontModuleCase;

import FontModule.FontLibrary;
import FontModule.FontOpacity;
import io.appium.java_client.android.AndroidDriver;

public class FontOpacityCase {public FontOpacityCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void FontOpacityTestCase() {


        FontOpacity f = new FontOpacity(driver);

        try {
            f.FontOpacityTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
