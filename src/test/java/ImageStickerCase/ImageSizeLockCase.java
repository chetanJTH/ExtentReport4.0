package ImageStickerCase;

import ImageModule.ImageRotationLock;
import ImageModule.ImageSizeLock;
import io.appium.java_client.android.AndroidDriver;

public class ImageSizeLockCase {public ImageSizeLockCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImageSizeLockTestCase() {

        ImageSizeLock E = new ImageSizeLock(driver);

        try {
            E.ImageSizeLockTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

