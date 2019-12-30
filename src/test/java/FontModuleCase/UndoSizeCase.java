package FontModuleCase;

import FontModule.UndoRotation;
import FontModule.UndoSize;
import io.appium.java_client.android.AndroidDriver;

public class UndoSizeCase  {
    public UndoSizeCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UndoSizeTestCase() {


        UndoSize U = new UndoSize(driver);

        try {
            U.UndoSizeTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
