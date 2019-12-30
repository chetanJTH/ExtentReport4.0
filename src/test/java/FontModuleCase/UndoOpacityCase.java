package FontModuleCase;

import FontModule.UndoOpacity;
import FontModule.UndoRedo;
import io.appium.java_client.android.AndroidDriver;

public class UndoOpacityCase  {
    public UndoOpacityCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UndoOpacityTestCase() {


        UndoOpacity U = new UndoOpacity(driver);

        try {
            U.UndoOpacityTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
