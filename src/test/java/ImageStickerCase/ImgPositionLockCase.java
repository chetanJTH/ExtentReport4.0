package ImageStickerCase;

import ImageModule.ImgCropShape;
import ImageModule.ImgPositionLock;
import io.appium.java_client.android.AndroidDriver;

public class ImgPositionLockCase {public ImgPositionLockCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImgPositionLockTestCase() {

        ImgPositionLock C = new ImgPositionLock(driver);

        try {
            C.ImgPositionLockTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
