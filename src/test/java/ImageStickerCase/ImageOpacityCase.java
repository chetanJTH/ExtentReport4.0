package ImageStickerCase;

import ImageModule.ImageOpacity;
import ImageModule.ImageRotation;
import io.appium.java_client.android.AndroidDriver;

public class ImageOpacityCase{public ImageOpacityCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImageOpacityTestCase() {

        ImageOpacity E = new ImageOpacity(driver);

        try {
            E.ImageOpacityTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

