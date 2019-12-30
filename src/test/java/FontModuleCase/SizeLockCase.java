package FontModuleCase;

import FontModule.SizeLock;
import FontModule.TextSize;
import io.appium.java_client.android.AndroidDriver;

public class SizeLockCase {
    public SizeLockCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void SizeLockTestCase() {


        SizeLock S = new SizeLock(driver);

        try {
            S.SizeLockTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
