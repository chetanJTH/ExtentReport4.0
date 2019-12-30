package ImageStickerCase;

import ImageModule.ImageSize;
import io.appium.java_client.android.AndroidDriver;

public class ImageSizeCase {
    public ImageSizeCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ImageSizeTestCase() {

        ImageSize E = new ImageSize(driver);

        try {
            E.ImageSizeTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
