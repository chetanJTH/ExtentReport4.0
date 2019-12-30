package ImageStickerCase;

import ImageModule.EditImage;
import ImageModule.ImageColor;
import io.appium.java_client.android.AndroidDriver;

public class ImageColorCase  {public ImageColorCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImageColorTestCase() {

        ImageColor E = new ImageColor(driver);

        try {
            E.ImageColorTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
