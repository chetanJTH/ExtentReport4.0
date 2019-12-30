package FontModuleCase;

import FontModule.UndoRedo;
import FontModule.UndoRotation;
import io.appium.java_client.android.AndroidDriver;

public class UndoRotationCase  {
    public UndoRotationCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UndoRotationTestCase() {


        UndoRotation U = new UndoRotation(driver);

        try {
            U.UndoRotationTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
