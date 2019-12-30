package FontModuleCase;

import FontModule.UndoColor;
import FontModule.UndoSize;
import io.appium.java_client.android.AndroidDriver;

public class UndoColorCase {
    public UndoColorCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UndoColorTestCase() {


        UndoColor U = new UndoColor(driver);

        try {
            U.UndoColorTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
