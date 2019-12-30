package FontModuleCase;

import FontModule.UndoColor;
import FontModule.UndoFont;
import io.appium.java_client.android.AndroidDriver;

public class UndoFontCase {
    public UndoFontCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UndoFontTestCase() {


        UndoFont U = new UndoFont(driver);

        try {
            U.UndoFontTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
