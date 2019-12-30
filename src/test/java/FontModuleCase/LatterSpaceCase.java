package FontModuleCase;

import FontModule.FontOpacity;
import FontModule.LatterSpace;
import io.appium.java_client.android.AndroidDriver;

public class LatterSpaceCase {public LatterSpaceCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void LatterSpaceTestCase() {


        LatterSpace L = new LatterSpace(driver);

        try {
            L.LatterSpaceTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
