package ImageStickerCase;

import ImageModule.EraseImage;
import ImageModule.ImageRotation;
import io.appium.java_client.android.AndroidDriver;

public class ImageRotationCase {public ImageRotationCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImageRotationTestCase() {

        ImageRotation E = new ImageRotation(driver);

        try {
            E.ImageRotationTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
