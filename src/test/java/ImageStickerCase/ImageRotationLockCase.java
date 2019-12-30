package ImageStickerCase;

import ImageModule.ImageRotation;
import ImageModule.ImageRotationLock;
import io.appium.java_client.android.AndroidDriver;

public class ImageRotationLockCase {public ImageRotationLockCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImageRotationLockTestCase() {

        ImageRotationLock E = new ImageRotationLock(driver);

        try {
            E.ImageRotationLockTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
