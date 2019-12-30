package FontModuleCase;

import FontModule.PositionLock;
import io.appium.java_client.android.AndroidDriver;

public class PositionLockCase {
    public PositionLockCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void PositionLockTestCase() {


        PositionLock P = new PositionLock(driver);

        try {
            P.PositionLockTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
