package FontModuleCase;

import FontModule.TextSize;
import FontModule.UndoRedo;
import io.appium.java_client.android.AndroidDriver;

public class UndoRedoCase {
    public UndoRedoCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UndoRedoTest() {


        UndoRedo U = new UndoRedo(driver);

        try {
            U.UndoRedoText();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
