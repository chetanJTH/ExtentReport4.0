package FontModuleCase;

import FontModule.FrameLayer;
import FontModule.LatterSpace;
import io.appium.java_client.android.AndroidDriver;

public class FrameLayerCase {public FrameLayerCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void FrameLayerTestCase() {


        FrameLayer F = new FrameLayer(driver);

        try {
            F.FrameLayerTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
