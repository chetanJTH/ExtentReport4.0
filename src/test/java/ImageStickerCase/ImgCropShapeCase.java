package ImageStickerCase;

import ImageModule.ImgCropShape;
import io.appium.java_client.android.AndroidDriver;

public class ImgCropShapeCase {public ImgCropShapeCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImgCropShapeTestCase() {

        ImgCropShape C = new ImgCropShape(driver);

        try {
            C.ImgCropShapeTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

