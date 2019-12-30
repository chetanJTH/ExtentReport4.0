package ImageStickerCase;

import ImageModule.EraseMinimize;
import ImageModule.ImageColor;
import io.appium.java_client.android.AndroidDriver;

public class EraseMinimizeCase {public EraseMinimizeCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void EraseMinimizeTestCase() {

        EraseMinimize E = new EraseMinimize(driver);

        try {
            E.EraseMinimizeTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
