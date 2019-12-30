package ImageStickerCase;

import ImageModule.ImgAutoSave;
import ImageModule.ImgCropShape;
import io.appium.java_client.android.AndroidDriver;

public class ImgAutoSaveCase {public ImgAutoSaveCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImgAutoSaveTestCase() {

        ImgAutoSave C = new ImgAutoSave(driver);

        try {
            C.ImgAutoSaveTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
