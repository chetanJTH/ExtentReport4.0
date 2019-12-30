package FontModuleCase;

import FontModule.UndoColor;
import FontModule.UndoShadow;
import io.appium.java_client.android.AndroidDriver;

public class UndoShadowCase  {
    public UndoShadowCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void UndoShadowTestCase() {


        UndoShadow U = new UndoShadow(driver);

        try {
            U.UndoShadowTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
