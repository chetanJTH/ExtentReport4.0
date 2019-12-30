package FontModuleCase;

import FontModule.UndoSize;
import FontModule.UndoStyle;
import io.appium.java_client.android.AndroidDriver;

public class UndoStyleCase {
    public UndoStyleCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UndoStyleTestCase() {


        UndoStyle U = new UndoStyle(driver);

        try {
            U.UndoStyleTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
