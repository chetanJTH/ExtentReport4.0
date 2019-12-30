package ImageStickerCase;

import ImageModule.ImagePosition;
import ImageModule.ImageRotation;
import io.appium.java_client.android.AndroidDriver;

public class ImagePositionCase {public ImagePositionCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImagePositionTestCase() {

        ImagePosition E = new ImagePosition(driver);

        try {
            E.ImagePositionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
