package FontModuleCase;

import FontModule.UndoLatterSpace;
import FontModule.UndoOpacity;
import io.appium.java_client.android.AndroidDriver;

public class UndoLatterSpaceCase {
    public UndoLatterSpaceCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UndoLatterSpaceTestCase() {


        UndoLatterSpace U = new UndoLatterSpace(driver);

        try {
            U.UndoLatterSpaceTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
