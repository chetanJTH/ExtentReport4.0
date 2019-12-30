package FontModuleCase;

import FontModule.PositionLock;
import FontModule.RotationLock;
import io.appium.java_client.android.AndroidDriver;

public class RotationLockCase {

    public RotationLockCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void RotationLockTestCase() {


        RotationLock U = new RotationLock(driver);

        try {
            U.RotationLockTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
