package ImageStickerCase;

import ImageModule.AddImage;
import ImageModule.EraseImage;
import io.appium.java_client.android.AndroidDriver;

public class EraseImageCase {public EraseImageCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void EraseImageTestCase() {

        EraseImage E = new EraseImage(driver);

        try {
            E.EraseImageTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}