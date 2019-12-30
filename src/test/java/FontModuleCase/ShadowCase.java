package FontModuleCase;

import FontModule.FontLibrary;
import FontModule.Shadow;
import io.appium.java_client.android.AndroidDriver;

public class ShadowCase {public ShadowCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ShadowTestCase() {


        Shadow s = new Shadow(driver);

        try {
            s.ShadowTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

