package ImageStickerCase;

import ImageModule.ImgAutoSave;
import ImageModule.ImgSave;
import io.appium.java_client.android.AndroidDriver;

public class ImgSaveCase {public ImgSaveCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImgSaveTestCase() {

        ImgSave C = new ImgSave(driver);

        try {
            C.ImgSaveTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

